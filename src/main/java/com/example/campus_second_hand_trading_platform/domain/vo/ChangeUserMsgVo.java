package com.example.campus_second_hand_trading_platform.domain.vo;

import lombok.Data;

@Data
public class ChangeUserMsgVo {
    private Integer id;
    private String userName;
    private String name;
    private String city;
    private String phone;
    private String gender;
    private String bankCard;
    private String email;
    private String introduction;
    private String wechat;
    private String img;
}
