package com.example.campus_second_hand_trading_platform.domain.vo;

import lombok.Data;

/**
 * 在个人中心中显示用户基本信息使用到的vo
 */
@Data
 public class UserMsgVo {
    private Integer id;
    private String userName;
    private String introduction;
    private Object credit;
    private String img;
}
