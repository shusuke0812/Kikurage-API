/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.shusuke.kikurage.devicestatus.infrastructure.database.record

import com.shusuke.kikurage.devicestatus.domain.RoleType
import java.util.Date

data class UserRecord(
    var id: Long? = null,
    var deviceId: Long? = null,
    var email: String? = null,
    var password: String? = null,
    var name: String? = null,
    var roleType: RoleType? = null,
    var createdAt: Date? = null,
    var updatedAt: Date? = null
)