package com.example.campus_second_hand_trading_platform.service.impl;

import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.example.campus_second_hand_trading_platform.dao.entity.Product;
import com.example.campus_second_hand_trading_platform.dao.mapper.OrderMapper;
import com.example.campus_second_hand_trading_platform.dao.mapper.ProductMapper;
import com.example.campus_second_hand_trading_platform.domain.vo.OrderVo;
import com.example.campus_second_hand_trading_platform.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.campus_second_hand_trading_platform.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author cc
 * @since 2023-05-21
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<OrderVo> GetOrderList(int id) {
        List<OrderVo> orderVoList;
        List<Order> orderList = orderMapper.GetOrderListById(id);
        orderVoList = BeanUtils.copyPropertiesList(orderList,OrderVo.class);
        return orderVoList;
    }
}
