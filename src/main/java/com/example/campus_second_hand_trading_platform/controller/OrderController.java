package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.config.CommonResult;
import com.example.campus_second_hand_trading_platform.domain.vo.OrderVo;
import com.example.campus_second_hand_trading_platform.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

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
@Controller
@RequestMapping("/order")
public class OrderController {
    IOrderService service;

    /**
     * 获取订单列表
     * @param id 用户id
     * @return 订单列表
     */
    @GetMapping("/GetOrderList")
    public CommonResult<List<OrderVo>> GetOrderListById(@RequestParam int id){
        log.debug("id=",id);
        return CommonResult.success(service.GetOrderList(id));
    }
}
