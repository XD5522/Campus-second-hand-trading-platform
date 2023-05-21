package com.example.campus_second_hand_trading_platform.dao.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    int id;         //评论id
    int user_id;    //
    int product_id;
    String type;
    int content;
    String img;
    LocalDateTime time;
}
