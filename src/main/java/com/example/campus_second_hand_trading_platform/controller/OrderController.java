package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import com.example.campus_second_hand_trading_platform.domain.vo.OrderVo;
import com.example.campus_second_hand_trading_platform.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author cc
 * @since 2023-05-21
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService service;

    /**
     * 获取订单列表
     * @param id 用户id
     * @return 订单列表
     */
    @GetMapping("/GetOrderList")
    public CommonResult<List<OrderVo>> GetOrderListById(@RequestParam int id){
        return CommonResult.success(service.GetOrderList(id));
    }

    /**
     * 更新订单状态
     * @param orderdto
     * @return 更新成功/失败
     */
    @PostMapping("/update")
    public CommonResult<?> Update(@RequestBody Order orderdto){
        log.info(orderdto.toString());
        if(service.updateOrder(orderdto)==1){
            return CommonResult.success(orderdto,"update success");
        }else{
            log.debug("update fail",orderdto);
            return CommonResult.failed("update fail");
        }
    }
}
