package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.service.IProductService;
import jdk.jfr.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/product")
public class ProductController {

    IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @RequestMapping
    public ResponseEntity<?> GetProductById(HttpRequest request, @RequestBody int productId){


        return ResponseEntity.ok("1");
    }

}
