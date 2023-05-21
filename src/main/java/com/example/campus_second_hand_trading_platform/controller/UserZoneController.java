package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import com.example.campus_second_hand_trading_platform.dao.entity.Product;
import com.example.campus_second_hand_trading_platform.domain.dto.AddProductDTO;
import com.example.campus_second_hand_trading_platform.service.IAddProductService;
import com.example.campus_second_hand_trading_platform.utils.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户个人中心的功能接口
 */
@Slf4j
@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserZoneController {
    @Autowired
    IAddProductService addProductService;

    @PostMapping("/AddNewProduct")
    public CommonResult AddNewProduct(@RequestBody AddProductDTO data){
        Product product = new Product();
        BeanUtils.copyProperties(data,product);
        log.info(product.toString());

        if(addProductService.save(product)){
            return CommonResult.success(product);
        }else{
            log.debug("插入失败",product);
            return CommonResult.failed("插入失败");
        }
    }
}
