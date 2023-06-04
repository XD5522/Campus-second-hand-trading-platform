package com.example.campus_second_hand_trading_platform.domain.dto;

import lombok.Data;

@Data
public class LoginDataDto {
    String userName;
    String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
