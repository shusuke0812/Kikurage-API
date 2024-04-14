package com.shusuke.kikurage.devicestatus.presentation.controller

import com.shusuke.kikurage.devicestatus.application.AdminDeviceService
import com.shusuke.kikurage.devicestatus.presentation.form.RegisterDeviceRequest
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("admin/device")
@CrossOrigin(origins = ["http://localhost:8003"], allowCredentials = "true")
class AdminDeviceController(
    private val adminDeviceService: AdminDeviceService
) {
    @PostMapping("/register")
    fun register() {
        val request = RegisterDeviceRequest()
        adminDeviceService.register(
            request.temperature,
            request.humidity,
            request.statusType
        )
    }
}