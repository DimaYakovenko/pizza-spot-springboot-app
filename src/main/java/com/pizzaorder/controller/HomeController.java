package com.pizzaorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/user")
    public String user() {
        return "<h1>Hello authenticated users</h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1>Hello Admin</h1>";
    }
}
