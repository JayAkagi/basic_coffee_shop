package com.chilling.projectOne.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {

    @GetMapping("/admin_panel")
    public String adminPanel(HttpSession session){
        Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
        if(isAdmin == null || !isAdmin){
            return "redirect:/";
        }

        return "admin/panel";
    }
}
