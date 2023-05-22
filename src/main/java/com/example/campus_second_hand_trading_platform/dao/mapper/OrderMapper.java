package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.campus_second_hand_trading_platform.domain.vo.OrderVo;
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
    List<OrderVo> GetOrderListById(int id);
    int updateOrder(@Param("id") int id,@Param("state") String state);
    List<OrderVo> GetPendingList(int id);
}
