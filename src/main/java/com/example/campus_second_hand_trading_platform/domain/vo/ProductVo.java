package com.example.campus_second_hand_trading_platform.domain.vo;

import lombok.Data;

@Data
public class ProductVo {
    private Integer id;
    
    private Integer userId;

    private String userName;

    private String name;

    private String intro;

    private Object price;

    private Integer stock;

    private Integer hisSales;

    private String size;

    private String type;

    private Object star;

    private String trading;

    private String state;

    public ProductVo() {
    }
}
