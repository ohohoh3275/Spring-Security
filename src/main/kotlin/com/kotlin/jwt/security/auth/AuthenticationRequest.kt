package com.kotlin.jwt.security.auth

data class AuthenticationRequest(
    val username: String,
    val password: String
)
