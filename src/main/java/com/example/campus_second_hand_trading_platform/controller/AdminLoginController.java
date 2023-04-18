package com.example.campus_second_hand_trading_platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供管理员登陆功能
 */
@RestController
@RequestMapping("/back")
public class AdminLoginController {
    @GetMapping("AdminLogin")
    void Login(){

    }
}
