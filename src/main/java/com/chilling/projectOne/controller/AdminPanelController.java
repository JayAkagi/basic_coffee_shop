package com.chilling.projectOne.controller;

import com.chilling.projectOne.model.ShopDetails;
import com.chilling.projectOne.model.User;
import com.chilling.projectOne.repository.ShopDetailsRepository;
import com.chilling.projectOne.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminPanelController {
    private final ShopDetailsRepository shopDetailsRepository;
    private final UserRepository userRepository;

    public AdminPanelController(
            ShopDetailsRepository shopDetailsRepository,
            UserRepository userRepository
    ){
        this.shopDetailsRepository = shopDetailsRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/admin_panel")
    public String adminPanel(Model model, HttpSession session){
        Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
        if(isAdmin == null || !isAdmin){
            return "redirect:/";
        }

        List<ShopDetails> shops = shopDetailsRepository.findAll();
        ShopDetails shop = null;
        if(shops.size() > 0){
            shop = shops.get(0);
        }

        Long userId = (Long) session.getAttribute("userId");
        Optional<User> userOpt = userRepository.findById(userId);
        User user = null;
        if(userOpt.isPresent()){
            user = userOpt.get();
        }

        model.addAttribute("user", user);
        model.addAttribute("shop", shop);

        return "admin/admin_panel";
    }
}
