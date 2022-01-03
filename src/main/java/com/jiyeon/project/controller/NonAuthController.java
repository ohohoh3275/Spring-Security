package com.jiyeon.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/non-auth")
public class NonAuthController {

    @GetMapping
    public String main() {
        return "non-auth ~ hello world";
    }
}
