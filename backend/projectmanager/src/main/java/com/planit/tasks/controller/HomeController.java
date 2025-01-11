package com.planit.tasks.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";  
    }

    @GetMapping("/user")
    public String userPage(@AuthenticationPrincipal User user) {
        return "user";  
    }

    @GetMapping("/admin")
    public String adminPage(@AuthenticationPrincipal User user) {
        return "admin"; 
    }
}
