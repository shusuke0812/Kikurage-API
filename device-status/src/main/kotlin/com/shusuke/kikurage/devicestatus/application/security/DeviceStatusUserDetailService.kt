package com.shusuke.kikurage.devicestatus.application.security

import com.shusuke.kikurage.devicestatus.application.AuthenticationService
import com.shusuke.kikurage.devicestatus.domain.RoleType
import com.shusuke.kikurage.devicestatus.domain.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import java.util.*

class DeviceStatusUserDetailService(
    private val authenticationService: AuthenticationService
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails? {
        val user = authenticationService.findUser(username)
        return user?.let { DeviceStatusUserDetails(user) }
    }
}

data class DeviceStatusUserDetails(
    val id: Long,
    val deviceId: Long,
    val email: String,
    val pass: String, // NOTE: You should name `pass`. if you set `password` for example, there are errors "the following declarations have the same JVM signature (getPassword()Ljava/lang/String".
    val roleType: RoleType,
    val createdAt: Date,
    val updatedAt: Date
) : UserDetails {
    constructor(user: User) : this(user.id, user.deviceId, user.email, user.password, user.roleType, user.createdAt, user.updatedAt)

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList(this.roleType.toString())
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return this.email
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return this.pass
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}