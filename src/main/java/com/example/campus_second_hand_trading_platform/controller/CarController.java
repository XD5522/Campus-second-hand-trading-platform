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

import java.util.List;

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
            log.info(car.toString());
            log.info(car.toString());
            log.info(car.toString());
            log.info(car.toString());
            log.info(car.toString());
            carService.save(car);
            return CommonResult.success(car);
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }

    /**
     *
     * @param request
     * @param current
     * @param num
     * @return
     */
    @GetMapping
    public CommonResult<?> getCarList(HttpServletRequest request,@RequestParam int current,@RequestParam int num){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"info");
        IPage<CarVo> carList;
        try{
            BeanUtils.copyProperties(object,user);
            log.info(user.toString());
            carList = carService.getCarByUserId(user.getId(), current,num);
            log.info(carList.toString());
            return CommonResult.success(carList);
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }

    @DeleteMapping
    public CommonResult<?> deleteProductFromCar(HttpServletRequest request,@RequestBody List<Integer> ids){
        log.info(ids.toString());
        try{
            log.info(ids.toString());
            log.info(ids.toString());
            log.info(ids.toString());
            log.info(ids.toString());
            log.info(ids.toString());
            log.info(ids.toString());
            boolean result = carService.removeBatchByIds(ids);
            if(result){
                return CommonResult.success(ids);

            }
            else{
                return CommonResult.failed("删除失败");
            }
        }
        catch (Exception e){
            log.info("删除失败"+e.getMessage());
            return CommonResult.failed("删除失败");
        }
    }
    @PostMapping("upCar")
    public CommonResult<?> updateProductFromCar(@RequestParam int id,@RequestParam int num){
        Car car = carService.getById(id);
        log.info(String.valueOf(id));
        log.info(carService.getById(id).toString());
        car.setNum(num);
        try{
            carService.updateById(car);
            return CommonResult.success(car);
        }
        catch (Exception e){
            log.info("修改失败"+e.getMessage());
            return CommonResult.failed("修改失败");
        }
    }

    @PostMapping("getCarByIds")
    public CommonResult<?> getCarByIds(@RequestBody List<Integer> ids){
        List<CarVo> cars;
        log.info(ids.toString());
        cars = carService.getCarByIds(ids);
        log.info(cars.toString());
        return CommonResult.success(cars);
    }


}
