package com.example.campus_second_hand_trading_platform.service;

import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.campus_second_hand_trading_platform.domain.vo.OrderVo;

import java.util.List;
/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author cc
 * @since 2023-05-21
 */
public interface IOrderService extends IService<Order> {
    public List<OrderVo> GetOrderList(int id);
}
