package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.campus_second_hand_trading_platform.dao.entity.Address;
import com.example.campus_second_hand_trading_platform.dao.entity.Coupon;
import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.mapper.*;
import com.example.campus_second_hand_trading_platform.domain.dto.OrderDto;
import com.example.campus_second_hand_trading_platform.service.CouponService;
import com.example.campus_second_hand_trading_platform.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cc
 */

@Service
@Slf4j
public class PayServiceImpl extends ServiceImpl<OrderMapper, Order> implements PayService {
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public List<Address> getAddress(int id) {
        return addressMapper.getAddress(id);
    }
    @Override
    public List<Coupon> getCoupon(int id) {
        return couponMapper.getCoupon(id);
    }

    @Override
    public User getWallet(int id) {
        return userMapper.selectById(id);
    }



    @Override
    public String addOrder(Order order) {

        log.info(order.toString());
        orderMapper.insertOrder(order);

        int stock = productMapper.selectById(order.getProductId()).getStock()-order.getProductNum();
        int hisSale = productMapper.selectById(order.getProductId()).getHisSales()+ order.getProductNum();
        if(stock<0){
            return productMapper.selectById(order.getProductId()).getName();
        }
        log.info(String.valueOf(stock));
        log.info(String.valueOf(stock));
        log.info(String.valueOf(stock));
        couponMapper.deleteById(order.getCouponId());
        productMapper.sellProduct(order.getProductId(),stock,hisSale);
        redisTemplate.opsForHash().delete("product",order.getProductId());
        log.info("111");
        double buyer = userMapper.selectById(order.getBuyer()).getWallet();
        userMapper.setWallet(order.getBuyer(),buyer-order.getTotal());
        double seller = userMapper.selectById(order.getSeller()).getWallet();
        userMapper.setWallet(order.getSeller(),seller+order.getTotal()*0.95);

        return "";

    }

    @Override
    public void setScore(int buyer,int score) {
        score = userMapper.selectById(buyer).getScore()-score;
        userMapper.setScore(buyer,score);
    }

}
