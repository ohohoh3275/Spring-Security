package com.jiyeon.project.controller;

import com.jiyeon.project.domain.User;
import com.jiyeon.project.repository.UserRepository;
import com.jiyeon.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;



@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
// issue test
    @GetMapping("/main")
    public ModelAndView main(@RequestParam Long id){

        List<User> userList = userService.findByUserId(id);
        ModelAndView mv = new ModelAndView();

        Optional<User> userOptional = userRepository.findByUserId(id);

        System.out.println(userOptional.get().getName());
        System.out.println("------1user ----name -----");

        System.out.println(userOptional.get().getAge());

        System.out.println("------1user ----age -----");

        System.out.println(userList.get(0).getUserId());
        System.out.println("------user ----id -----");

        System.out.println(userList.get(0).getName());
        System.out.println("------user ----name -----");

        mv.setViewName("main.html");

        return mv;
    }
}
