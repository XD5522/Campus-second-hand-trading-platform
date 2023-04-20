package com.example.campus_second_hand_trading_platform.domain.vo;

import lombok.Builder;
import lombok.Data;


public class AdminVo {
    private Integer id;

    private String adminAccount;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdminVo() {
    }
}
