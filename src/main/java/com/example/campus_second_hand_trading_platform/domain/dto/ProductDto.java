package com.example.campus_second_hand_trading_platform.domain.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer UserId;

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

    private String img;

    private String state;
}
