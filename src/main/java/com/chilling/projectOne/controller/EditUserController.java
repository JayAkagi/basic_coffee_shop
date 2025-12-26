package com.chilling.projectOne.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditUserController {

    @GetMapping("/edit_user")
    public String editUser(){
        return "admin/edit_user";
    }
}
