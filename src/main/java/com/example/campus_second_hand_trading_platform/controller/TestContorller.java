package com.example.campus_second_hand_trading_platform.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TestContorller {
    @GetMapping("/test")

    public List<Integer> Test(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        return list;
    }
}
