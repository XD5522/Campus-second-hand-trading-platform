package com.example.campus_second_hand_trading_platform.dao.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author cc
 */
@Data
public class Car {
    private Integer id;
    private Integer productId;
    private Integer userId;
    private Integer num;
    private LocalDateTime createTime;
    private Integer flag;

}
