package com.example.myboxchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.myboxchat.model.User;
import com.example.myboxchat.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        User user = userService.findByUsername(username);
        ModelAndView modelAndView = new ModelAndView();
        if (user != null && user.getPassword().equals(password)) {
            modelAndView.setViewName("home");
            modelAndView.addObject("user", user);
        } else {
        	modelAndView.setViewName("forward:/login");
        }
        return modelAndView;
        }
    
}
