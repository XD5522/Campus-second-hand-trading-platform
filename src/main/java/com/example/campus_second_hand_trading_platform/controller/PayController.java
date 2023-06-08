package com.example.campus_second_hand_trading_platform.controller;


import com.example.campus_second_hand_trading_platform.dao.entity.Address;
import com.example.campus_second_hand_trading_platform.dao.entity.Coupon;
import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.mapper.UserMapper;
import com.example.campus_second_hand_trading_platform.domain.vo.CarVo;
import com.example.campus_second_hand_trading_platform.service.*;
import com.example.campus_second_hand_trading_platform.utils.BeanUtils;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author cc
 */
@RestController
@CrossOrigin
@RequestMapping("/pay")
@Slf4j
public class PayController {
    @Autowired
    PayService payService;
    @Autowired
    IOrderService orderService;

    @Autowired
    CarService carService;
    @Autowired
    CouponService couponService;
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("address")
    public CommonResult<?> getAddress(HttpServletRequest request){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"info");
        try{
            BeanUtils.copyProperties(object,user);
            int id = user.getId();
            return CommonResult.success(payService.getAddress(id));
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping("coupon")
    public CommonResult<?> getCoupon(HttpServletRequest request){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"info");
        try{
            BeanUtils.copyProperties(object,user);
            int id = user.getId();
            log.info(String.valueOf(id));
            log.info(String.valueOf(id));
            log.info(String.valueOf(id));
            log.info(payService.getCoupon(id).toString());
            return CommonResult.success(payService.getCoupon(id));
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping("wallet")
    public CommonResult<?> getWallet(HttpServletRequest request){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"info");
        try{
            BeanUtils.copyProperties(object,user);
            int id = user.getId();
            User user1 = payService.getWallet(id);
            return CommonResult.success(user1.getWallet());
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping("score")
    public CommonResult<?> getScore(HttpServletRequest request){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"info");
        try{
            BeanUtils.copyProperties(object,user);
            int id = user.getId();
            User user1 = payService.getWallet(id);
            return CommonResult.success(user1.getScore());
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }

    @PostMapping("addOrder")
    public CommonResult<?> addOrder(@RequestBody List<CarVo> cars,@RequestParam int buyer,
                                    @RequestParam String name,@RequestParam String trading,
                                    @RequestParam String address,@RequestParam String phone,
                                    @RequestParam Integer coupon,@RequestParam Integer score){
        Order order = new Order();
        StringBuilder message = new StringBuilder();
        order.setBuyer(buyer);
        order.setBuyerName(name);
        order.setTrading(trading);
        order.setAddress(address);
        order.setPhone(phone);
        order.setCouponId(coupon);
        double coupon1 = 0.0;
        double score1 = score;
        if(coupon!=0) {
            coupon1 = (double) couponService.getById(coupon).getValue();
        }

        double num = cars.size();
        double sum =0.0;
        try{
            for(CarVo car: cars){
                order.setProductId(car.getProductId());
                order.setSeller(car.getSellerId());
                order.setProductNum(car.getNum());
                order.setCouponPrice(coupon1/num);
                order.setTotal(car.getPrice()*car.getNum()-coupon1/num-score1/num);
                order.setProductName(car.getName());
                order.setBuyerPayout(order.getTotal());
                order.setSellerIncome(order.getTotal()*0.95);
                log.info(order.toString());
                String ans = payService.addOrder(order);
                if(!Objects.equals(ans, "")){
                    message.append(ans);
                }
                else{
                    sum +=  car.getPrice()*car.getNum();
                    carService.removeById(car.getId());
                }
            }
            sum-=coupon1;
            score1/=100;
            score1=sum-score1>0?score1:sum;
            score1*=100;
            score = (int)score1;
            payService.setScore(buyer,score);
            return CommonResult.success(message);
        }catch (Exception e){
            return CommonResult.failed(e.getMessage());
        }

    }

}
