package com.example.campus_second_hand_trading_platform.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * TODO
 *
 * @Description 用户视图对象
 * @Author qionghua
 * @Date 2023/4/21 11:42
 **/
@TableName("user_account")
public class UserVo {

    private String userName;

    private String name;

    private String type;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
