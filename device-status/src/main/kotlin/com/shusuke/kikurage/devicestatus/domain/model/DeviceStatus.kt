package com.shusuke.kikurage.devicestatus.domain.model

import com.shusuke.kikurage.devicestatus.domain.StatusType

data class DeviceStatus(
    val deviceId: Long,
    val temperature: Int,
    val humidity: Int,
    val statusType: StatusType
)