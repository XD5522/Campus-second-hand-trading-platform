package com.example.campus_second_hand_trading_platform.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * TODO
 *
 * @Description 用户视图对象
 * @Author qionghua
 * @Date 2023/4/21 11:42
 **/
@Data
public class UserVo {

    private int id;

    private String userName;

    private String name;

    private String type;

    private String state;

    private String city;

    private String img;

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
