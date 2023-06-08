package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.campus_second_hand_trading_platform.dao.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author 16646
 */
@Mapper
public interface CouponMapper extends BaseMapper<Coupon> {
    public List<Coupon> getCoupon(int id);
}
