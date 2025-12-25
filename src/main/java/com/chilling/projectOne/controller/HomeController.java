package com.chilling.projectOne.controller;

import com.chilling.projectOne.model.ShopDetails;
import com.chilling.projectOne.repository.ShopDetailsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ShopDetailsRepository shopDetailsRepository;

    public HomeController(ShopDetailsRepository shopDetailsRepository){
        this.shopDetailsRepository = shopDetailsRepository;
    }

    @GetMapping("/")
    public String Home(Model model){
        List<ShopDetails> shops = shopDetailsRepository.findAll();
        ShopDetails shop = null;

        if(shops.size() > 0){
            shop = shops.get(0);
        }

        System.out.println("Shops size: " + shops.size());
        model.addAttribute("shop", shop);

        return "index/home";
    }
}
