package com.example.campus_second_hand_trading_platform.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author cc
 */
@Data
public class CarVo {
    private int productId;
    private String name;
    private String userName;
    private Object price;
    private String size;
    private LocalDateTime joinTime;
    private String productImg;
}
