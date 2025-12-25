package com.chilling.projectOne.controller;

import com.chilling.projectOne.model.User;
import com.chilling.projectOne.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AuthController {
    private UserRepository userRepository;

    public AuthController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session
    ){
        Optional<User> userOpt = userRepository.findByUsername(username);

        if(userOpt.isEmpty()){
            return "redirect:/login?error";
        }

        User user = userOpt.get();

        session.setAttribute("userId", user.getId());
        session.setAttribute("isAdmin", user.isAdmin());

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
