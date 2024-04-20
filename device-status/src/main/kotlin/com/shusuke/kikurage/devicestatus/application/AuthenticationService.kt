package com.shusuke.kikurage.devicestatus.application

import com.shusuke.kikurage.devicestatus.domain.model.User
import com.shusuke.kikurage.devicestatus.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val userRepository: UserRepository
) {
    fun findUser(email: String): User? {
        return userRepository.find(email)
    }
}