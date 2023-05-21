package com.example.campus_second_hand_trading_platform.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderVo {
    private Integer id;
    private Integer product_id;
    private String product_name;
    private LocalDateTime create_time;
    private LocalDateTime finish_time;
    private String trading;
    private Integer buyer;
    private Integer seller;
    private String state;
}
