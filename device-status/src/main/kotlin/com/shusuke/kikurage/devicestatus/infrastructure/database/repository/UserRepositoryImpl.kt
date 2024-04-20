package com.shusuke.kikurage.devicestatus.infrastructure.database.repository

import com.shusuke.kikurage.devicestatus.domain.model.User
import com.shusuke.kikurage.devicestatus.domain.repository.UserRepository
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.UserDynamicSqlSupport
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.UserMapper
import com.shusuke.kikurage.devicestatus.infrastructure.database.mapper.selectOne
import com.shusuke.kikurage.devicestatus.infrastructure.database.record.UserRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val mapper: UserMapper
) : UserRepository {
    override fun find(email: String): User? {
        val record = mapper.selectOne {
            where(UserDynamicSqlSupport.User.email, isEqualTo(email))
        }
        return record?.let { toModel(it) }
    }

    private fun toModel(record: UserRecord): User {
        return User(
            id = record.id!!,
            deviceId = record.deviceId!!,
            email = record.email!!,
            password = record.password!!,
            roleType = record.roleType!!,
            createdAt = record.createdAt!!,
            updatedAt = record.updatedAt!!
        )
    }
}