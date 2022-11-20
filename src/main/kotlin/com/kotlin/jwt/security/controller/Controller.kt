package com.kotlin.jwt.security.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/hi")
    fun hi(): String {
        return "hi security"
    }
}