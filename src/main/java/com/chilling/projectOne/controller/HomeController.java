package com.chilling.projectOne.controller;

import com.chilling.projectOne.model.Drink;
import com.chilling.projectOne.model.ShopDetails;
import com.chilling.projectOne.repository.DrinkRepository;
import com.chilling.projectOne.repository.ShopDetailsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ShopDetailsRepository shopDetailsRepository;
    private final DrinkRepository drinkRepository;

    public HomeController(
            ShopDetailsRepository shopDetailsRepository,
            DrinkRepository drinkRepository
    ){
        this.shopDetailsRepository = shopDetailsRepository;
        this.drinkRepository = drinkRepository;
    }

    @GetMapping("/")
    public String Home(Model model){
        List<ShopDetails> shops = shopDetailsRepository.findAll();
        List<Drink> drinks = drinkRepository.findByIsActiveTrue();

        ShopDetails shop = null;
        if(shops.size() > 0){
            shop = shops.get(0);
        }

        model.addAttribute("shop", shop);
        model.addAttribute("drinks", drinks);

        return "index/home";
    }
}
