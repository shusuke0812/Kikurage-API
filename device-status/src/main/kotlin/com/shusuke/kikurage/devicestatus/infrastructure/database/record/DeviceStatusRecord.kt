/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.shusuke.kikurage.devicestatus.infrastructure.database.record

import com.shusuke.kikurage.devicestatus.domain.StatusType

data class DeviceStatusRecord(
    var deviceId: Long? = null,
    var temperature: Int? = null,
    var humidity: Int? = null,
    var statusType: StatusType? = null
)