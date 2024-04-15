package com.shusuke.kikurage.devicestatus.domain.repository

import com.shusuke.kikurage.devicestatus.domain.StatusType
import com.shusuke.kikurage.devicestatus.domain.model.DeviceStatus

interface DeviceStatusRepository {
    fun countAllRows(): Long
    fun findStatus(deviceId: Long): DeviceStatus?
    fun register(status: DeviceStatus)
    fun update(deviceId: Long, temperature: Int, humidity: Int, statusType: StatusType)
    fun delete(deviceId: Long)
}