package com.shusuke.kikurage.devicestatus.presentation.form

import com.shusuke.kikurage.devicestatus.domain.StatusType

data class GetDeviceStatusResponse(
    val temperature: Int,
    val humidity: Int,
    val statusType: StatusType
)