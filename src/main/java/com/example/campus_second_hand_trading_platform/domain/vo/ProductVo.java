package com.example.campus_second_hand_trading_platform.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cc
 */
@Data
public class ProductVo implements Serializable {
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

    private String img;
    private Integer userCount;

    public ProductVo() {
    }
}
