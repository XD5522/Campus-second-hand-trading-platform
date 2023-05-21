package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2023-05-21
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> GetOrderListById(int id);
}
