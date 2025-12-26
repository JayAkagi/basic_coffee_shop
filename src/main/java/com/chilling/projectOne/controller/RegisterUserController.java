package com.chilling.projectOne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterUserController {

    @GetMapping("/register")
    public String register(){
        return "admin/register";
    }
}
