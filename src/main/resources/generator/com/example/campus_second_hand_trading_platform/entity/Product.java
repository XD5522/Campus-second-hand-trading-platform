package com.example.campus_second_hand_trading_platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author qionghua
 * @since 2023-05-06
 */
@ApiModel(value = "Product对象", description = "")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("pk")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("所属人")
    private Integer userId;

    @ApiModelProperty("商品名")
    private String name;

    @ApiModelProperty("介绍")
    private String intro;

    @ApiModelProperty("价格")
    private Object price;

    @ApiModelProperty("库存")
    private Integer inventory;

    @ApiModelProperty("历史销量")
    private Integer hisSales;

    @ApiModelProperty("商品尺寸")
    private Object size;

    @ApiModelProperty("商品类型")
    private String type;

    @ApiModelProperty("历史评价")
    private Object star;

    @ApiModelProperty("交易方式")
    private String trading;

    @ApiModelProperty("商品状态(审核，正常，封禁)")
    private String state;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getHisSales() {
        return hisSales;
    }

    public void setHisSales(Integer hisSales) {
        this.hisSales = hisSales;
    }

    public Object getSize() {
        return size;
    }

    public void setSize(Object size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getStar() {
        return star;
    }

    public void setStar(Object star) {
        this.star = star;
    }

    public String getTrading() {
        return trading;
    }

    public void setTrading(String trading) {
        this.trading = trading;
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
        return "Product{" +
        "id = " + id +
        ", userId = " + userId +
        ", name = " + name +
        ", intro = " + intro +
        ", price = " + price +
        ", inventory = " + inventory +
        ", hisSales = " + hisSales +
        ", size = " + size +
        ", type = " + type +
        ", star = " + star +
        ", trading = " + trading +
        ", state = " + state +
        ", flag = " + flag +
        "}";
    }
}
