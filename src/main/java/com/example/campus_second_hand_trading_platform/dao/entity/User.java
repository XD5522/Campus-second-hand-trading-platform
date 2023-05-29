package com.example.campus_second_hand_trading_platform.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.campus_second_hand_trading_platform.domain.dto.RegisterDataDto;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cc
 * @since 2023-04-04
 */
@TableName("user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userName;

    private String name;

    private String type;

    private String state;

    private Integer level;

    private Integer wallet;

    private String city;

    private String phone;

    private String gender;

    private String bankCard;

    private String email;

    private String introduction;

    private String license;

    private Object credit;

    private String wechat;

    private Integer score;

    private String img;

    public User() {
    }

    public User(RegisterDataDto registerDataDto) {

        userName = registerDataDto.getUserName();
        name = registerDataDto.getName();
        city = registerDataDto.getCity();
        phone = registerDataDto.getPhone();
        gender = registerDataDto.getGender();
        bankCard = registerDataDto.getBankCard();
        email = registerDataDto.getEmail();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getWallet() {
        return wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Object getCredit() {
        return credit;
    }

    public void setCredit(Object credit) {
        this.credit = credit;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id = " + id +
                ", userName = " + userName +
                ", name = " + name +
                ", type = " + type +
                ", state = " + state +
                ", level = " + level +
                ", wallet = " + wallet +
                ", city = " + city +
                ", phone = " + phone +
                ", gender = " + gender +
                ", bankCard = " + bankCard +
                ", email = " + email +
                ", introduction = " + introduction +
                ", license = " + license +
                ", credit = " + credit +
                ", wechat = " + wechat +
                ", score = " + score +
                "}";
    }
}
