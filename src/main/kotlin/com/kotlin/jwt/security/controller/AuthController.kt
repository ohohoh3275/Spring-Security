package com.kotlin.jwt.security.controller

import SecurityConfig
import com.kotlin.jwt.security.auth.AuthenticationRequest
import com.kotlin.jwt.security.auth.AuthenticationResponse
import com.kotlin.jwt.security.util.JwtUtil
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class AuthController(val userDetailService: UserDetailsService) {

    // 이부분 생성자도?? ???
    var ac: ApplicationContext = AnnotationConfigApplicationContext(SecurityConfig::class.java)
    val authenticationManager = ac.getBean(AuthenticationManager::class.java)
    val jwtUtil: JwtUtil = JwtUtil()

    @GetMapping("/hi")
    fun hi(): String {
        return "hi security"
    }

    @PostMapping("/auth")
    fun createAuthToken(): ResponseEntity<Any> {
        println("authauth")
//        println(request.username)
//        try {
//            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(request.username, request.password))
//        } catch (e: BadCredentialsException) {
//            throw Exception("올바르지 않은 아이디 비번", e)
//        }
//
//        val userDetails: UserDetails = userDetailService.loadUserByUsername(request.username)
//        val jwt: String? = jwtUtil.generateToken(userDetails)

        println("??")
        //return ResponseEntity.ok(jwt?.let { AuthenticationResponse(it) })
        return ResponseEntity.ok("okok")
    }
}
