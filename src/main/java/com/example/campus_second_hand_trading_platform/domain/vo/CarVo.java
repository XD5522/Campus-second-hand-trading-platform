package com.example.campus_second_hand_trading_platform.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author cc
 */
@Data
public class CarVo {
    private int id;
    private int sellerId;
    private int productId;
    private String name;
    private String userName;
    private int num;
    private double price;
    private LocalDateTime joinTime;
    private String img;
}
