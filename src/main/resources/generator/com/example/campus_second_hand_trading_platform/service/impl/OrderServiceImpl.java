package com.example.campus_second_hand_trading_platform.service.impl;

import com.example.campus_second_hand_trading_platform.entity.Order;
import com.example.campus_second_hand_trading_platform.mapper.OrderMapper;
import com.example.campus_second_hand_trading_platform.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author cc
 * @since 2023-06-04
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
