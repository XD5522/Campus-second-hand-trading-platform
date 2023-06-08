package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.campus_second_hand_trading_platform.dao.entity.Coupon;
import com.example.campus_second_hand_trading_platform.dao.mapper.CouponMapper;
import com.example.campus_second_hand_trading_platform.service.CouponService;
import org.springframework.stereotype.Service;


@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {
}
