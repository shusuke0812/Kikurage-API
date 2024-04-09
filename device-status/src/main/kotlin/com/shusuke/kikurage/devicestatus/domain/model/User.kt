package com.shusuke.kikurage.devicestatus.domain.model

import com.shusuke.kikurage.devicestatus.domain.RoleType
import java.util.Date

data class User(
    val id: Long,
    val deviceId: Long,
    val email: String,
    val password: String,
    val roleType: RoleType,
    val createdAt: Date,
    val updatedAt: Date
)
