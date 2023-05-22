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
    /**
     * 通过id查找订单列表
     * @param id 用户id
     * @return List<OrderVo> 订单列表
     */
    public List<OrderVo> GetOrderList(int id);

    /**
     * 更新订单状态
     * @param order 订单
     * @return 数据库受影响行数
     */
    public int updateOrder(Order order);

    /**
     * 查询用户待处理的退货订单列表
     * @param id
     * @return 订单列表
     */
    public List<OrderVo> GetPendingList(int id);
}
