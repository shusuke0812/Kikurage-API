package com.shusuke.kikurage.devicestatus.application

import com.shusuke.kikurage.devicestatus.domain.StatusType
import com.shusuke.kikurage.devicestatus.domain.model.DeviceStatus
import com.shusuke.kikurage.devicestatus.domain.repository.DeviceStatusRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminDeviceService(
    private val deviceStatusRepository: DeviceStatusRepository
) {
    @Transactional
    fun register(temperature: Int, humidity: Int, statusType: StatusType) {
        val deviceId: Long = deviceStatusRepository.countAllRows() + 1
        deviceStatusRepository.register(DeviceStatus(
            deviceId,
            temperature,
            humidity,
            statusType
        ))
    }
}