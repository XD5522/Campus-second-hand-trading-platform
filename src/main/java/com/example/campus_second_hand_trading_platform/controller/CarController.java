package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.domain.dto.CarDto;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author cc
 */
@RestController
@CrossOrigin
@RequestMapping("car")
public class CarController {
    @PostMapping
    public CommonResult<?> addProductToCar(HttpServletRequest request, @RequestBody CarDto carDto){

        return CommonResult.success("1");
    }

}
