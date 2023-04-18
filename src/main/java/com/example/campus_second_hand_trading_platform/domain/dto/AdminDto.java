package com.example.campus_second_hand_trading_platform.domain.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class AdminDto {
    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdminDto() {
    }
}
