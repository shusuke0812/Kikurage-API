/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.shusuke.kikurage.devicestatus.infrastructure.database.mapper

import com.shusuke.kikurage.devicestatus.domain.RoleType
import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.SqlTable

object UserDynamicSqlSupport {
    object User : SqlTable("user") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val deviceId = column<Long>("device_id", JDBCType.BIGINT)

        val email = column<String>("email", JDBCType.VARCHAR)

        val password = column<String>("password", JDBCType.VARCHAR)

        val name = column<String>("name", JDBCType.VARCHAR)

        val roleType = column<RoleType>("role_type", JDBCType.CHAR, "org.apache.ibatis.type.EnumTypeHandler")

        val createdAt = column<Date>("created_at", JDBCType.TIMESTAMP)

        val updatedAt = column<Date>("updated_at", JDBCType.TIMESTAMP)
    }
}