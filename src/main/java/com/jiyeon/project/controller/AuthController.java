package com.jiyeon.project.controller;

import com.jiyeon.project.entity.Employee;
import com.jiyeon.project.entity.EmployeeSecurity;
import com.jiyeon.project.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final EmployeeRepository employeeRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public @ResponseBody String loginOK () {
        System.out.println(">>login??");
        return "log in ed";
    }

    @PostMapping("/join")
    public @ResponseBody String joinOK(Employee employee){

        System.out.println(">>> join??");

        String rawPassword = employee.getPassword();
        String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);

        employee.setPassword(encodedPassword);
        employee.setRole("USER_ROLE");

        employeeRepository.save(employee);

        return "joined";
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("logout.html");

        return mv;
    }

}
