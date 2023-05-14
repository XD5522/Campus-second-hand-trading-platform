package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.Repository.ProductRepository;
import com.example.campus_second_hand_trading_platform.domain.dto.searchDto;
import com.example.campus_second_hand_trading_platform.domain.vo.ProductVo;
import com.example.campus_second_hand_trading_platform.service.IProductService;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/product")
public class ProductController {

    IProductService productService;
    IUserService userService;

    @Autowired
    public ProductController(IProductService productService, IUserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/search")
    public ResponseEntity<?> SearchProductByName(HttpServletRequest request, @RequestParam String name){
        List<ProductVo> products = productService.SearchProducts(name);
        log.info(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<?> GetProductById(HttpServletRequest request, @RequestParam int id){
        ProductVo product = productService.SelectProductById(id);
        return ResponseEntity.ok(product);
    }


}
