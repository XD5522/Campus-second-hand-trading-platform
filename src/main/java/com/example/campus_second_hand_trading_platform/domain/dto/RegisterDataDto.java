package com.example.campus_second_hand_trading_platform.domain.dto;

/**
 * TODO
 *
 * @Description 注册信息数据传输对象
 * @Author qionghua
 * @Date 2023/4/23 20:38
 **/
public class RegisterDataDto {

    private String userName; // 用户名

    private String name; // 姓名

    private String city; // 城市

    private String phone; // 手机号

    private String gender; // 性别

    private String bankCard; // 银行卡

    private String email; // 邮箱

    private String password; // 密码

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterDataDto{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
