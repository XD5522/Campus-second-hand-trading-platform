package com.example.campus_second_hand_trading_platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContorller {
    @GetMapping("/test")
    public String Test(){
        return "success";
    }
}
