package com.example.campus_second_hand_trading_platform.controller;


import com.example.campus_second_hand_trading_platform.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cc
 */
@RestController
@CrossOrigin
@RequestMapping("/pay")
public class PayController {

    @Autowired
    IOrderService service;



}
