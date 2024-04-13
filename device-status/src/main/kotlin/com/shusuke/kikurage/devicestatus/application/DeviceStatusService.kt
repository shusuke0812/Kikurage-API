package com.shusuke.kikurage.devicestatus.application

import com.shusuke.kikurage.devicestatus.domain.model.DeviceStatus
import com.shusuke.kikurage.devicestatus.domain.repository.DeviceStatusRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeviceStatusService(
    private val deviceStatusRepository: DeviceStatusRepository
) {
    fun getDeviceStatus(deviceId: Long): DeviceStatus {
        return deviceStatusRepository.findStatus(deviceId) ?: throw IllegalArgumentException("Not found Device ID")
    }

    @Transactional
    fun register(deviceStatus: DeviceStatus) {
        deviceStatusRepository.findStatus(deviceStatus.deviceId)?.let { throw IllegalArgumentException("Existing ID: ${deviceStatus.deviceId}") }
        deviceStatusRepository.register(deviceStatus)
    }
}