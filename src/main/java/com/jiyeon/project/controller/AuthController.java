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

    /**
     *  /auth/login이 403뜬다... 왜????
     *  /auth/join
     *
     *  1. 프론트랑 따로 쓰다가 붙혀 쓰다가 해서 그럴수도
     *  2. html경로?
     *  3--유력 : securityConfig를 손봐야한다
     *
     *  --> 해결하고나서 구글아이디에서 회원가입하도록 정보 받아와야한다.
     */
    
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
