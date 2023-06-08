package com.example.campus_second_hand_trading_platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.campus_second_hand_trading_platform.dao.entity.Address;
import com.example.campus_second_hand_trading_platform.dao.entity.Coupon;
import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.domain.dto.OrderDto;

import java.util.List;

/**
 * @author cc
 */

public interface PayService extends IService<Order> {
    public List<Address> getAddress(int id);
    public List<Coupon> getCoupon(int id);
    public User getWallet(int id);

    public String addOrder(Order order);

    public void setScore(int buyer,int score);

}
