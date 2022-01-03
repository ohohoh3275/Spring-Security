package com.jiyeon.project.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String main() {
        return "main ~ hello world";
    }
}
