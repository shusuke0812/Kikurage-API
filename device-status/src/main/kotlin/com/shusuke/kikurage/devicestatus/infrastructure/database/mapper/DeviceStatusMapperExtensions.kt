/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.shusuke.kikurage.devicestatus.infrastructure.database.mapper

import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.DeviceStatusDynamicSqlSupport.DeviceStatus
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.DeviceStatusDynamicSqlSupport.DeviceStatus.deviceId
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.DeviceStatusDynamicSqlSupport.DeviceStatus.humidity
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.DeviceStatusDynamicSqlSupport.DeviceStatus.statusType
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.DeviceStatusDynamicSqlSupport.DeviceStatus.temperature
import com.shusuke.kikurage.devicestatus.infrastructure.database.record.DeviceStatusRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun DeviceStatusMapper.count(completer: CountCompleter) =
    countFrom(this::count, DeviceStatus, completer)

fun DeviceStatusMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, DeviceStatus, completer)

fun DeviceStatusMapper.deleteByPrimaryKey(deviceId_: Long) =
    delete {
        where(deviceId, isEqualTo(deviceId_))
    }

fun DeviceStatusMapper.insert(record: DeviceStatusRecord) =
    insert(this::insert, record, DeviceStatus) {
        map(deviceId).toProperty("deviceId")
        map(temperature).toProperty("temperature")
        map(humidity).toProperty("humidity")
        map(statusType).toProperty("statusType")
    }

fun DeviceStatusMapper.insertMultiple(records: Collection<DeviceStatusRecord>) =
    insertMultiple(this::insertMultiple, records, DeviceStatus) {
        map(deviceId).toProperty("deviceId")
        map(temperature).toProperty("temperature")
        map(humidity).toProperty("humidity")
        map(statusType).toProperty("statusType")
    }

fun DeviceStatusMapper.insertMultiple(vararg records: DeviceStatusRecord) =
    insertMultiple(records.toList())

fun DeviceStatusMapper.insertSelective(record: DeviceStatusRecord) =
    insert(this::insert, record, DeviceStatus) {
        map(deviceId).toPropertyWhenPresent("deviceId", record::deviceId)
        map(temperature).toPropertyWhenPresent("temperature", record::temperature)
        map(humidity).toPropertyWhenPresent("humidity", record::humidity)
        map(statusType).toPropertyWhenPresent("statusType", record::statusType)
    }

private val columnList = listOf(deviceId, temperature, humidity, statusType)

fun DeviceStatusMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, DeviceStatus, completer)

fun DeviceStatusMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, DeviceStatus, completer)

fun DeviceStatusMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, DeviceStatus, completer)

fun DeviceStatusMapper.selectByPrimaryKey(deviceId_: Long) =
    selectOne {
        where(deviceId, isEqualTo(deviceId_))
    }

fun DeviceStatusMapper.update(completer: UpdateCompleter) =
    update(this::update, DeviceStatus, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: DeviceStatusRecord) =
    apply {
        set(deviceId).equalTo(record::deviceId)
        set(temperature).equalTo(record::temperature)
        set(humidity).equalTo(record::humidity)
        set(statusType).equalTo(record::statusType)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: DeviceStatusRecord) =
    apply {
        set(deviceId).equalToWhenPresent(record::deviceId)
        set(temperature).equalToWhenPresent(record::temperature)
        set(humidity).equalToWhenPresent(record::humidity)
        set(statusType).equalToWhenPresent(record::statusType)
    }

fun DeviceStatusMapper.updateByPrimaryKey(record: DeviceStatusRecord) =
    update {
        set(temperature).equalTo(record::temperature)
        set(humidity).equalTo(record::humidity)
        set(statusType).equalTo(record::statusType)
        where(deviceId, isEqualTo(record::deviceId))
    }

fun DeviceStatusMapper.updateByPrimaryKeySelective(record: DeviceStatusRecord) =
    update {
        set(temperature).equalToWhenPresent(record::temperature)
        set(humidity).equalToWhenPresent(record::humidity)
        set(statusType).equalToWhenPresent(record::statusType)
        where(deviceId, isEqualTo(record::deviceId))
    }