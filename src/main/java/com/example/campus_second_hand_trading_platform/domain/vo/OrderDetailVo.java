package com.example.campus_second_hand_trading_platform.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDetailVo {
    int id;
    LocalDateTime create_time;
    LocalDateTime finish_time;
    int seller_id;
    String seller_name;
    String seller_img;
    int buyer_id;
    String buyer_name;
    String buyer_img;
    String address;
    int product_id;
    String product_name;
    String product_img;
    Object price;
    int product_num;
    int coupon_id;
    String coupon_type;
    Object total;
    Object buyer_payout;
    String trading;
    String state;
}
