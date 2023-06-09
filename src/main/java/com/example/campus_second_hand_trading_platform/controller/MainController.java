package com.example.campus_second_hand_trading_platform.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.domain.vo.ProductVo;
import com.example.campus_second_hand_trading_platform.service.IProductService;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @Description
 * @Author qionghua
 * @Date 2023/6/9 17:14
 **/
@Slf4j
@RequestMapping("/main")
@RestController
@CrossOrigin
public class MainController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/searchProduct")
    public CommonResult<?> searchProductByName(HttpServletRequest request, @RequestParam String name, @RequestParam int current, @RequestParam int num, @RequestParam String order, @RequestParam String asc){
        IPage<ProductVo> products = iProductService.SearchProducts(name, order, asc, current, num);
        log.info(order);
        return CommonResult.success(products);
    }
}
