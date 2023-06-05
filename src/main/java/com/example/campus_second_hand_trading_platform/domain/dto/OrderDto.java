package com.example.campus_second_hand_trading_platform.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class OrderDto {
    private Integer id;
    @ApiModelProperty("商品id")
    private Integer productId;
    @ApiModelProperty("买家id")
    private Integer buyer;
    @ApiModelProperty("卖家id")
    private Integer seller;
    @ApiModelProperty("交易方式")
    private String trading;
    @ApiModelProperty("优惠券")
    private Integer couponId;
    private String productName;
    private Integer productNum;
    @ApiModelProperty("优惠券金额")
    private Object couponPrice;
    @ApiModelProperty("总价")
    private Object total;
    private String state;
}
