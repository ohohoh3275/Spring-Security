package com.kotlin.jwt.security.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class JWTUserDetailService() : UserDetailsService {

    val passwordEncoder: PasswordEncoder
        get() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder()
        }

    override fun loadUserByUsername(userName: String): UserDetails {
        return User("user1", passwordEncoder.encode("userpassword"), emptyList())
    }
}
