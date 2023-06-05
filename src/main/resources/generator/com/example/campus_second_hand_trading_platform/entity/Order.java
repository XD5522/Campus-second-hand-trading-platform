package com.example.campus_second_hand_trading_platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author cc
 * @since 2023-06-04
 */
@ApiModel(value = "Order对象", description = "订单表")
public class Order implements Serializable {

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

    @ApiModelProperty("优惠券金额")
    private Object couponPrice;

    @ApiModelProperty("总价")
    private Object total;

    private String state;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBuyer() {
        return buyer;
    }

    public void setBuyer(Integer buyer) {
        this.buyer = buyer;
    }

    public Integer getSeller() {
        return seller;
    }

    public void setSeller(Integer seller) {
        this.seller = seller;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public String getTrading() {
        return trading;
    }

    public void setTrading(String trading) {
        this.trading = trading;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Object getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(Object couponPrice) {
        this.couponPrice = couponPrice;
    }

    public Object getTotal() {
        return total;
    }

    public void setTotal(Object total) {
        this.total = total;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Order{" +
        "id = " + id +
        ", productId = " + productId +
        ", buyer = " + buyer +
        ", seller = " + seller +
        ", createTime = " + createTime +
        ", finishTime = " + finishTime +
        ", trading = " + trading +
        ", couponId = " + couponId +
        ", productName = " + productName +
        ", productNum = " + productNum +
        ", couponPrice = " + couponPrice +
        ", total = " + total +
        ", state = " + state +
        ", flag = " + flag +
        "}";
    }
}
