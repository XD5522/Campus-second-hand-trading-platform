package com.example.campus_second_hand_trading_platform.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.campus_second_hand_trading_platform.domain.dto.RegisterDataDto;

/**
 * TODO
 *
 * @Description 用户账户类
 * @Author qionghua
 * @Date 2023/4/20 11:41
 **/
@TableName("user_account")
public class UserAccount {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String userAccount;

    private String userPassword;

    private Integer flag;

    public UserAccount(RegisterDataDto registerDataDto, int userId) {

        userAccount = registerDataDto.getUserName();
        userPassword = registerDataDto.getPassword();
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id = " + id +
                ", userId = " + userId +
                ", userAccount = " + userAccount +
                ", userPassword = " + userPassword +
                ", flag = " + flag +
                "}";
    }

}
