package com.kotlin.jwt.security.controller

import com.kotlin.jwt.security.auth.AuthenticationRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class AuthController()  {

    val authenticationManager: AuthenticationManager = AuthenticationManager()

    @GetMapping("/hi")
    fun hi(): String {
        return "hi security"
    }

    @PostMapping("/auth")
    fun createAuthToken(@RequestBody request: AuthenticationRequest): ResponseEntity<Unit> {
        try {
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(request.username, request.password))

        } catch (e: BadCredentialsException) {
            throw Exception("올바르지 않은 아이디 비번", e)
        }
    }
}