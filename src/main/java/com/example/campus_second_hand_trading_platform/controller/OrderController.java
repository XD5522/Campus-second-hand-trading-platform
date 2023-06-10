package com.example.campus_second_hand_trading_platform.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.dao.entity.Order;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import com.example.campus_second_hand_trading_platform.domain.vo.OrderVo;
import com.example.campus_second_hand_trading_platform.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
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
        log.debug("GetOrderList: id="+String.valueOf(id));
        return CommonResult.success(service.GetOrderList(id));
    }

    @GetMapping("GetOrderListByPage")
    public CommonResult<IPage<OrderVo>> GetOrderListByPage(@RequestParam int Id, @RequestParam int PageSize, @RequestParam int PageNum){
        return CommonResult.success(service.GetOrderListByPage(Id,PageSize,PageNum));
    }

    /**
     * 买家的获取订单方法
     * @param Id
     * @param PageSize
     * @param PageNum
     * @param State
     * @return
     */
    @GetMapping("GetOrderListByPage&State")
    public CommonResult<IPage<OrderVo>> GetOrderListByPageAndState(@RequestParam int Id, @RequestParam int PageSize, @RequestParam int PageNum,@RequestParam String State){
        return CommonResult.success(service.GetOrderListByPageAndState(Id,PageSize,PageNum,State));
    }

    /**
     * 卖家的获取订单方法
     * @param Id
     * @param PageSize
     * @param PageNum
     * @param State
     * @return
     */
        @GetMapping("SellerGetOrderListByPage&State")
    public CommonResult<IPage<OrderVo>> SellerGetOrderListByState(@RequestParam int Id, @RequestParam int PageSize, @RequestParam int PageNum,@RequestParam String State){
        return CommonResult.success(service.SellerGetOrderListByState(Id,PageSize,PageNum,State));
    }
    @GetMapping("GetOrderUnfinishedListByPage")
    public CommonResult<IPage<OrderVo>> GetOrderUnfinishedListByPage(@RequestParam int Id, @RequestParam int PageSize, @RequestParam int PageNum){
        return CommonResult.success(service.GetOrderUnfinishedListByPage(Id,PageSize,PageNum));
    }

    @GetMapping("GetOrderDetail")
    public CommonResult GetOrderDetail(@RequestParam int order_id){
        return CommonResult.success(service.GetOrderDetail(order_id));
    }

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

    /**
     * 提供把订单状态修改成完成的接口
     * @param order_id
     */
    @GetMapping("/finishOrder")
    public CommonResult OrderFinish(@RequestParam int order_id) {
        Order order = new Order();
        order.setId(order_id);
        order.setState("已完成");
        return CommonResult.success(service.updateOrder(order));
    }
    @GetMapping("/cancelOrder")
    public CommonResult OrderCancel(@RequestParam int order_id){
        return CommonResult.success(service.OrderCancel(order_id));
    }

    @GetMapping("/returnProduct")
    public CommonResult ProductReturn(@RequestParam int order_id){
        return CommonResult.success(service.ProductReturn(order_id));
    }

    @GetMapping("seller")
    public CommonResult SellerOperation(@RequestParam int order_id,@RequestParam String operation){
        return CommonResult.success(service.SellerOperation(order_id,operation));
    }
}
