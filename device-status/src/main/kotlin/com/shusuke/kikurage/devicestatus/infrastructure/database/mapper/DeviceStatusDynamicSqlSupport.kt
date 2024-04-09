/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.shusuke.kikurage.devicestatus.infrastructure.database.mapper

import com.shusuke.kikurage.devicestatus.domain.StatusType
import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object DeviceStatusDynamicSqlSupport {
    object DeviceStatus : SqlTable("device_status") {
        val deviceId = column<Long>("device_id", JDBCType.BIGINT)

        val temperature = column<Int>("temperature", JDBCType.INTEGER)

        val humidity = column<Int>("humidity", JDBCType.INTEGER)

        val statusType = column<StatusType>("status_type", JDBCType.CHAR, "org.apache.ibatis.type.EnumTypeHandler")
    }
}