package com.example.campus_second_hand_trading_platform.dao.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    int id;         //评论id
    int user_id;
    Object star;
    int product_id;
    String content;
    LocalDateTime time;
}
