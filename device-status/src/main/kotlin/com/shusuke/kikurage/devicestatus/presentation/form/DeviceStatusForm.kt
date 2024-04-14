package com.shusuke.kikurage.devicestatus.presentation.form

import com.shusuke.kikurage.devicestatus.domain.StatusType

///////// Response
data class GetDeviceStatusResponse(
    val temperature: Int,
    val humidity: Int,
    val statusType: StatusType
)

///////// Request
data class UpdateDeviceStatusRequest(
    val temperature: Int,
    val humidity: Int
) {
    val statusType: StatusType
        get() {
            if (humidity in 70..85) {
                return StatusType.NORMAL
            } else if (humidity > 85) {
                return StatusType.WET
            } else {
                return StatusType.DRY
            }
        }
}


data class RegisterDeviceRequest(
    val deviceId: Long,
    val temperature: Int = 25,
    val humidity: Int = 70,
    val statusType: StatusType = StatusType.NORMAL
)
