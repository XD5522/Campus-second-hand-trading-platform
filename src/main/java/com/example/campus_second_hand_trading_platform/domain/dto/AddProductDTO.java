package com.example.campus_second_hand_trading_platform.domain.dto;

import lombok.Data;

/**
 * 定义商家新增商品功能使用的DTO
 */
@Data
public class AddProductDTO {
    private Integer user_id;//上传用户id
    private String  name;//商品名称
    private String  intro;//商品介绍
    private Object  price;//商品价格
    private Integer stock;//商品库存
    private String  size;//商品尺寸
    private Object  star;//商品类型
    private String  trading;//交易方式
}
