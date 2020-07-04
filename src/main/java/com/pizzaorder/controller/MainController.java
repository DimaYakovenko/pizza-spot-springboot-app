package com.pizzaorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // Login form with error
    @GetMapping("/login.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
