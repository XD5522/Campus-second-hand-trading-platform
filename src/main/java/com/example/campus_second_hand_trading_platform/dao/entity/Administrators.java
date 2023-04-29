package com.example.campus_second_hand_trading_platform.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
* Description:administrator entity
* date: 2023/4/22 15:58
* @author cc
* @since JDK17
*/
@Data
@TableName("administrators")
public class Administrators implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String adminAccount;

    private String adminPassword;

    private String name;



    @Override
    public String toString() {
        return "Administrators{" +
        "id = " + id +
        ", adminAccount = " + adminAccount +
        ", adminPassword = " + adminPassword +
        ", name = " + name +
        "}";
    }
}
