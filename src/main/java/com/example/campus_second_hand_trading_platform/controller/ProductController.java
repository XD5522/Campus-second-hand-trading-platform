package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.Repository.ProductRepository;
import com.example.campus_second_hand_trading_platform.dao.entity.Product;
import com.example.campus_second_hand_trading_platform.domain.dto.searchDto;
import com.example.campus_second_hand_trading_platform.domain.vo.ProductVo;
import com.example.campus_second_hand_trading_platform.service.IProductService;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
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
    public CommonResult<?> searchProductByName(HttpServletRequest request, @RequestParam String name){
        List<ProductVo> products = productService.SearchProducts(name);
        log.info(name);
        return CommonResult.success(products);
    }

    @GetMapping
    public CommonResult<?> getProductById(HttpServletRequest request, @RequestParam int id){
        try{
            ProductVo product = productService.SelectProductById(id);
            return CommonResult.success(product);
        }
        catch (Exception e){
            return CommonResult.failed("搜索失败");
        }
    }

    @PostMapping
    public CommonResult<?> save(HttpServletRequest request,@RequestBody Product product){
        log.info(product.toString());
        try {
            productService.save(product);
        }
        catch (Exception e){
            return CommonResult.failed("添加失败");
        }

        return CommonResult.success("11");
    }


}
