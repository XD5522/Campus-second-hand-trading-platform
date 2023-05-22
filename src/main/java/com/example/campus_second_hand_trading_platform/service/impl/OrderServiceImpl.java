package com.example.campus_second_hand_trading_platform.service.impl;

import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.example.campus_second_hand_trading_platform.dao.mapper.OrderMapper;
import com.example.campus_second_hand_trading_platform.domain.vo.OrderVo;
import com.example.campus_second_hand_trading_platform.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author cc
 * @since 2023-05-21
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    OrderMapper mapper;
    @Override
    public List<OrderVo> GetOrderList(int id) {
        List<OrderVo> orderVoList = mapper.GetOrderListById(id);
        return orderVoList;
    }

    @Override
    public int updateOrder(Order order) {
        return mapper.updateOrder(order.getId(),order.getState());
    }

    @Override
    public List<OrderVo> GetPendingList(int id) {
        return mapper.GetPendingList(id);
    }
}
