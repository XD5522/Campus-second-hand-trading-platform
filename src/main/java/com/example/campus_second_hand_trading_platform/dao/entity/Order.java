package com.example.campus_second_hand_trading_platform.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author cc
 * @since 2023-05-21
 */
@Data
@ApiModel(value = "Order对象", description = "订单表")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer productId;
    private LocalDateTime createTime;
    private LocalDateTime finishTime;
    private String trading;
    private Integer buyer;
    private Integer seller;
    private String state;
    private Integer flag;
//    @Override
//    public String toString() {
//        return "Order{" +
//        "id = " + id +
//        ", productId = " + productId +
//        ", createTime = " + createTime +
//        ", finishTime = " + finishTime +
//        ", trading = " + trading +
//        ", buyer = " + buyer +
//        ", seller = " + seller +
//        ", state = " + state +
//        ", flag = " + flag +
//        "}";
//    }
}
