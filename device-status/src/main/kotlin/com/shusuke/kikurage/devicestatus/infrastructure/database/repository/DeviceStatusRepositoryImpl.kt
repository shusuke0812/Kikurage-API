package com.shusuke.kikurage.devicestatus.infrastructure.database.repository

import com.shusuke.kikurage.devicestatus.domain.model.DeviceStatus
import com.shusuke.kikurage.devicestatus.domain.repository.DeviceStatusRepository
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.DeviceStatusMapper
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.selectByPrimaryKey
import com.shusuke.kikurage.devicestatus.infrastructure.database.record.DeviceStatusRecord

class DeviceStatusRepositoryImpl(
    private val deviceStatusMapper: DeviceStatusMapper
) : DeviceStatusRepository {
    override fun findStatus(deviceId: Long): DeviceStatus? {
        return deviceStatusMapper.selectByPrimaryKey(deviceId)?.let { toModel(it) }
    }

    private fun toModel(record: DeviceStatusRecord): DeviceStatus {
        return DeviceStatus(
            deviceId = record.deviceId!!,
            temperature = record.temperature!!,
            humidity = record.humidity!!,
            statusType = record.statusType!!
        )
    }
}