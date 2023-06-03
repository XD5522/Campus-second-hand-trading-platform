package com.example.campus_second_hand_trading_platform.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.dao.entity.Car;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.mapper.CarMapper;
import com.example.campus_second_hand_trading_platform.domain.dto.CarDto;
import com.example.campus_second_hand_trading_platform.domain.vo.CarVo;
import com.example.campus_second_hand_trading_platform.service.CarService;
import com.example.campus_second_hand_trading_platform.utils.BeanUtils;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author cc
 */
@RestController
@CrossOrigin
@RequestMapping("car")
@Slf4j
public class CarController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    CarService carService;
    @PostMapping
    public CommonResult<?> addProductToCar(HttpServletRequest request, @RequestBody CarDto carDto){
        Car car = new Car();
        try{
            BeanUtils.copyProperties(carDto,car);
            carService.save(car);
            return CommonResult.success(car);
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }

    @GetMapping
    public CommonResult<?> getCarList(HttpServletRequest request,@RequestParam int current,@RequestParam int num){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"token");
        IPage<CarVo> carList;
        try{
            BeanUtils.copyProperties(object,user);
            carList = carService.getCarByUserId(user.getId(), current,num);
            return CommonResult.success(carList);
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }

}
