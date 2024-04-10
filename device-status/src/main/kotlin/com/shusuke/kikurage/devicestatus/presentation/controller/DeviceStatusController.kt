package com.shusuke.kikurage.devicestatus.presentation.controller

import com.shusuke.kikurage.devicestatus.application.DeviceStatusService
import com.shusuke.kikurage.devicestatus.presentation.form.GetDeviceStatusResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/{device_id/status}")
class DeviceStatusController(
    private val deviceStatusService: DeviceStatusService
) {
    @GetMapping
    fun getDeviceStatus(@PathVariable("device_id") deviceId: Long): GetDeviceStatusResponse {
        val status = deviceStatusService.getDeviceStatus(deviceId)
        return GetDeviceStatusResponse(
            temperature = status.temperature,
            humidity = status.humidity,
            statusType = status.statusType
        )
    }
}