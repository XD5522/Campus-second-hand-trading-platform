package com.example.campus_second_hand_trading_platform.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
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

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("pk")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("商品id")
    private Integer productId;

    @ApiModelProperty("买家id")
    private Integer buyer;

    @ApiModelProperty("卖家id")
    private Integer seller;

    @ApiModelProperty("订单创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("收货时间")
    private LocalDateTime finishTime;

    @ApiModelProperty("交易方式")
    private String trading;

    @ApiModelProperty("优惠券")
    private Integer couponId;

    private String productName;

    private Integer productNum;

    private Integer buyer_payout;

    private Integer seller_income;

    @ApiModelProperty("优惠券金额")
    private Object couponPrice;

    @ApiModelProperty("总价")
    private Object total;

    private String state;

    private Integer flag;
}
