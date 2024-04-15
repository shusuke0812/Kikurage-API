package com.shusuke.kikurage.devicestatus.infrastructure.database.repository

import com.shusuke.kikurage.devicestatus.domain.StatusType
import com.shusuke.kikurage.devicestatus.domain.model.DeviceStatus
import com.shusuke.kikurage.devicestatus.domain.repository.DeviceStatusRepository
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.*
import com.shusuke.kikurage.devicestatus.infrastructure.database.record.DeviceStatusRecord
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class DeviceStatusRepositoryImpl(
    private val deviceStatusMapper: DeviceStatusMapper
) : DeviceStatusRepository {

    override fun countAllRows(): Long {
        val rows = deviceStatusMapper.count {
            allRows()
        }
        return rows
    }
    override fun findStatus(deviceId: Long): DeviceStatus? {
        return deviceStatusMapper.selectByPrimaryKey(deviceId)?.let { toModel(it) }
    }
    override fun register(status: DeviceStatus) {
        deviceStatusMapper.insert(toRecord(status))
    }

    override fun update(deviceId: Long, temperature: Int, humidity: Int, statusType: StatusType) {
        deviceStatusMapper.updateByPrimaryKeySelective(DeviceStatusRecord(deviceId, temperature, humidity, statusType))
    }

    override fun delete(deviceId: Long) {
        deviceStatusMapper.deleteByPrimaryKey(deviceId)
    }

    private fun toModel(record: DeviceStatusRecord): DeviceStatus {
        return DeviceStatus(
            deviceId = record.deviceId!!,
            temperature = record.temperature!!,
            humidity = record.humidity!!,
            statusType = record.statusType!!
        )
    }

    private fun toRecord(model: DeviceStatus): DeviceStatusRecord {
        return DeviceStatusRecord(
            deviceId = model.deviceId,
            temperature = model.temperature,
            humidity = model.humidity,
            statusType = model.statusType
        )
    }
}