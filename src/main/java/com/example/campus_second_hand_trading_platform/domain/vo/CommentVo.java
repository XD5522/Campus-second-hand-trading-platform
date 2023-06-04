package com.example.campus_second_hand_trading_platform.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentVo {
    int id;         //评论id
    int user_id;    //评论用户
    String user_name;  //用户名
    String img;     //用户头像
    int product_id; //评论产品id
    String product_name;//产品名
    String content; //评论内容
    Object star;//商品评分
    LocalDateTime time;//评论时间
}
