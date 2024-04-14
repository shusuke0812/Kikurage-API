package com.shusuke.kikurage.devicestatus.presentation.controller

import com.shusuke.kikurage.devicestatus.application.DeviceStatusService
import com.shusuke.kikurage.devicestatus.presentation.form.GetDeviceStatusResponse
import com.shusuke.kikurage.devicestatus.presentation.form.UpdateDeviceStatusRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("device")
@CrossOrigin(origins = ["http://localhost:8003"], allowCredentials = "true")
class DeviceStatusController(
    private val deviceStatusService: DeviceStatusService
) {
    @GetMapping("/status/{device_id}")
    fun getDeviceStatus(@PathVariable("device_id") deviceId: Long): GetDeviceStatusResponse {
        val status = deviceStatusService.getDeviceStatus(deviceId)
        return GetDeviceStatusResponse(
            temperature = status.temperature,
            humidity = status.humidity,
            statusType = status.statusType
        )
    }

    @PutMapping("/status/{device_id}")
    fun updateDeviceStatus(@PathVariable("device_id") deviceId: Long, @RequestBody request: UpdateDeviceStatusRequest) {
        deviceStatusService.update(deviceId, request.temperature, request.humidity, request.statusType)
    }
}