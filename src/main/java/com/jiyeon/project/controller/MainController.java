package com.jiyeon.project.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping
public class MainController {


    @GetMapping("/")
    public ModelAndView main() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("main.html");
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView loginForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("loginForm.html");

        return mv;
    }


    @GetMapping("/join")
    public ModelAndView joiForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("joinForm.html");

        return mv;
    }

}
