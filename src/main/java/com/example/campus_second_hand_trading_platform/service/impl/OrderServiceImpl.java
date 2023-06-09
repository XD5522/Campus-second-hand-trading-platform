package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.mapper.OrderMapper;
import com.example.campus_second_hand_trading_platform.dao.mapper.UserMapper;
import com.example.campus_second_hand_trading_platform.domain.vo.OrderDetailVo;
import com.example.campus_second_hand_trading_platform.domain.vo.OrderVo;
import com.example.campus_second_hand_trading_platform.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.campus_second_hand_trading_platform.service.IUserService;
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
    @Autowired
    IUserService userService;
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
    public IPage<OrderVo> SellerGetOrderListByState(int id, int pageSize, int pageNum, String state) {
        IPage<OrderVo> page = new Page<>(pageNum,pageSize);
        return mapper.SellerGetOrderListByState(page,id,state);
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

    @Override
    public int OrderCancel(int order_id) {
        Order order = mapper.GetById(order_id);
        int buyer_id = order.getBuyer();
        int seller_id = order.getSeller();
        User buyer = userService.getById(buyer_id);
        User seller = userService.getById(seller_id);
        buyer.setWallet(buyer.getWallet()+order.getBuyer_payout());
        seller.setWallet(seller.getWallet()-order.getSeller_income());
        userService.updateById(buyer);
        userService.updateById(seller);
        order.setId(order_id);
        order.setState("已取消");
        return updateOrder(order);
    }

    @Override
    public int ProductReturn(int order_id) {
        Order order = mapper.GetById(order_id);
        int seller_id = order.getSeller();
        User seller = userService.getById(seller_id);
        seller.setWallet(seller.getWallet()-order.getSeller_income());
        userService.updateById(seller);
        order.setId(order_id);
        order.setState("待退货");
        return updateOrder(order);
    }

    @Override
    public int SellerOperation(int order_id, String operation) {
        if(operation.equals("shipments")){
            return mapper.updateOrder(order_id,"已发货");
        }
        else if(operation.equals("AgreeReturn")){
            Order order = mapper.GetById(order_id);
            int buyer_id = order.getBuyer();
            User buyer = userService.getById(buyer_id);
            buyer.setWallet(buyer.getWallet()+order.getBuyer_payout());
            userService.updateById(buyer);
            return mapper.updateOrder(order_id,"已退货");
        }
        else if(operation.equals("RefuseReturn")){
            Order order = mapper.GetById(order_id);
            int seller_id = order.getSeller();
            User seller = userService.getById(seller_id);
            seller.setWallet(seller.getWallet()+order.getSeller_income());
            userService.updateById(seller);
            return mapper.updateOrder(order_id,"已完成");
        }else return 0;
    }
}
