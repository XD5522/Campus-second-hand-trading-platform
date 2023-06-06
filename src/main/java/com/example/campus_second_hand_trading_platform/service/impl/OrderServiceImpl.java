package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.example.campus_second_hand_trading_platform.dao.mapper.OrderMapper;
import com.example.campus_second_hand_trading_platform.domain.vo.OrderDetailVo;
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

    @Override
    public IPage<OrderVo> GetOrderListByPage(int Id,int PageSize,int PageNum) {
        IPage<OrderVo> page = new Page<>(PageNum,PageSize);
        return mapper.GetOrderListByPage(page,Id);
    }

    @Override
    public IPage<OrderVo> GetOrderListByPageAndState(int Id, int PageSize, int PageNum, String State) {
        IPage<OrderVo> page = new Page<>(PageNum,PageSize);
        return mapper.GetOrderListByPageAndState(page,Id,State);
    }

    @Override
    public OrderDetailVo GetOrderDetail(int order_id) {
        return mapper.GetOrderDetail(order_id);
    }

    @Override
    public IPage<OrderVo> GetOrderUnfinishedListByPage(int Id, int PageSize, int PageNum) {
        IPage<OrderVo> page = new Page<>(PageNum,PageSize);
        return mapper.GetOrderUnfinishedListByPage(page,Id);
    }
}
