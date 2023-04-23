package com.example.campus_second_hand_trading_platform.utils;

import org.springframework.util.DigestUtils;
public class md5 {
    public static void main(String[] args) {
        String password = "123";
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        String salt = "bistu";
        password = salt.charAt(0)+salt.charAt(1)+password+salt.charAt(2)+password.charAt(3)+password.charAt(4);
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(md5Password);
    }


}
