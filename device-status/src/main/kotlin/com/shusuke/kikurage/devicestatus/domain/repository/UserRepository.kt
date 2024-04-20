package com.shusuke.kikurage.devicestatus.domain.repository

import com.shusuke.kikurage.devicestatus.domain.model.User

interface UserRepository {
    fun find(email: String): User?
}