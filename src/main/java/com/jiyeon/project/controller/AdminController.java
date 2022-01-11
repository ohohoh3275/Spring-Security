package com.jiyeon.project.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping()
    public ModelAndView admin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin.html");

        return mv;
    }



}
