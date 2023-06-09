package com.example.campus_second_hand_trading_platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.campus_second_hand_trading_platform.domain.vo.OrderDetailVo;
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

    /**
     * 通过用户id进行分页查询用户订单
     * @param Id
     * @param PageSize
     * @param PageNum
     * @return IPage<OrderVo>
     */
    public IPage<OrderVo> GetOrderListByPage(int Id, int PageSize, int PageNum);

    /**
     * 通过买家id和订单状态进行分页查询
     * @param Id
     * @param PageSize
     * @param PageNum
     * @param State
     * @return IPage<OrderVo>
     */
    public IPage<OrderVo> GetOrderListByPageAndState(int Id,int PageSize,int PageNum,String State);

    /**
     * 通过卖家id和订单状态进行分页查询
     * @param id
     * @param pageSize
     * @param pageNum
     * @param state
     * @return
     */
    public IPage<OrderVo> SellerGetOrderListByState(int id, int pageSize, int pageNum, String state);
    /**
     * 通过订单id获取订单详细信息
     * @param order_id
     * @return
     */
    public OrderDetailVo GetOrderDetail(int order_id);

    /**
     * 通过用户id进行分页查询，查找未完成的订单
     * @param Id
     * @param PageSize
     * @param PageNum
     * @return
     */
    public IPage<OrderVo> GetOrderUnfinishedListByPage(int Id, int PageSize, int PageNum);

    /**
     * 订单取消业务
     * @param order_id
     * @return
     */
    public int OrderCancel(int order_id);

    /**
     * 退货业务
     * @param order_id
     * @return
     */
    public int ProductReturn(int order_id);

    public int SellerOperation(int order_id,String operation);

}
