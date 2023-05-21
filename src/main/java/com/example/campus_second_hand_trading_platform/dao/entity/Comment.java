package com.example.campus_second_hand_trading_platform.dao.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    int id;         //评论id
    int user_id;    //评论用户
    int product_id; //评论产品
    String type;    //评论
    String content; //评论内容
    String img;     //评论图片
    LocalDateTime time;//评论时间
}
