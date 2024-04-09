/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.shusuke.kikurage.devicestatus.infrastructure.database.mapper

import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.UserDynamicSqlSupport.User
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.UserDynamicSqlSupport.User.createdAt
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.UserDynamicSqlSupport.User.deviceId
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.UserDynamicSqlSupport.User.email
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.UserDynamicSqlSupport.User.id
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.UserDynamicSqlSupport.User.name
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.UserDynamicSqlSupport.User.password
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.UserDynamicSqlSupport.User.roleType
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.UserDynamicSqlSupport.User.updatedAt
import com.shusuke.kikurage.devicestatus.infrastructure.database.record.UserRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, User, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, User, completer)

fun UserMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun UserMapper.insert(record: UserRecord) =
    insert(this::insert, record, User) {
        map(id).toProperty("id")
        map(deviceId).toProperty("deviceId")
        map(email).toProperty("email")
        map(password).toProperty("password")
        map(name).toProperty("name")
        map(roleType).toProperty("roleType")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun UserMapper.insertMultiple(records: Collection<UserRecord>) =
    insertMultiple(this::insertMultiple, records, User) {
        map(id).toProperty("id")
        map(deviceId).toProperty("deviceId")
        map(email).toProperty("email")
        map(password).toProperty("password")
        map(name).toProperty("name")
        map(roleType).toProperty("roleType")
        map(createdAt).toProperty("createdAt")
        map(updatedAt).toProperty("updatedAt")
    }

fun UserMapper.insertMultiple(vararg records: UserRecord) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(record: UserRecord) =
    insert(this::insert, record, User) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(deviceId).toPropertyWhenPresent("deviceId", record::deviceId)
        map(email).toPropertyWhenPresent("email", record::email)
        map(password).toPropertyWhenPresent("password", record::password)
        map(name).toPropertyWhenPresent("name", record::name)
        map(roleType).toPropertyWhenPresent("roleType", record::roleType)
        map(createdAt).toPropertyWhenPresent("createdAt", record::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", record::updatedAt)
    }

private val columnList = listOf(id, deviceId, email, password, name, roleType, createdAt, updatedAt)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, User, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, User, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, User, completer)

fun UserMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, User, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserRecord) =
    apply {
        set(id).equalTo(record::id)
        set(deviceId).equalTo(record::deviceId)
        set(email).equalTo(record::email)
        set(password).equalTo(record::password)
        set(name).equalTo(record::name)
        set(roleType).equalTo(record::roleType)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(deviceId).equalToWhenPresent(record::deviceId)
        set(email).equalToWhenPresent(record::email)
        set(password).equalToWhenPresent(record::password)
        set(name).equalToWhenPresent(record::name)
        set(roleType).equalToWhenPresent(record::roleType)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
    }

fun UserMapper.updateByPrimaryKey(record: UserRecord) =
    update {
        set(deviceId).equalTo(record::deviceId)
        set(email).equalTo(record::email)
        set(password).equalTo(record::password)
        set(name).equalTo(record::name)
        set(roleType).equalTo(record::roleType)
        set(createdAt).equalTo(record::createdAt)
        set(updatedAt).equalTo(record::updatedAt)
        where(id, isEqualTo(record::id))
    }

fun UserMapper.updateByPrimaryKeySelective(record: UserRecord) =
    update {
        set(deviceId).equalToWhenPresent(record::deviceId)
        set(email).equalToWhenPresent(record::email)
        set(password).equalToWhenPresent(record::password)
        set(name).equalToWhenPresent(record::name)
        set(roleType).equalToWhenPresent(record::roleType)
        set(createdAt).equalToWhenPresent(record::createdAt)
        set(updatedAt).equalToWhenPresent(record::updatedAt)
        where(id, isEqualTo(record::id))
    }