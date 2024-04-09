package com.shusuke.kikurage.devicestatus.domain.model

data class DeviceStatus(
    val deviceId: Long,
    val temperature: Int,
    val humidity: Int,
    val status: DeviceStatus
)