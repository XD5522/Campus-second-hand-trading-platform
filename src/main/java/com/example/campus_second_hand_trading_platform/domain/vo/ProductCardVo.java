package com.example.campus_second_hand_trading_platform.domain.vo;

import lombok.Data;

@Data
public class ProductCardVo {
    private Integer id;
    private String name;
    private Object price;
    private Integer stock;
    private Integer hisSales;
    private Object star;
    private String state;
    private String img;
}
