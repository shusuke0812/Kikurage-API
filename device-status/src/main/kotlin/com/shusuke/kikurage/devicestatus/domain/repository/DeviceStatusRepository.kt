package com.shusuke.kikurage.devicestatus.domain.repository

import com.shusuke.kikurage.devicestatus.domain.model.DeviceStatus

interface DeviceStatusRepository {
    fun findStatus(deviceId: Long): DeviceStatus?
}