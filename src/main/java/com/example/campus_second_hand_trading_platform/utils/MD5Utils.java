package com.example.campus_second_hand_trading_platform.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * TODO
 *
 * @Description MD5工具包
 * @Author qionghua
 * @Date 2023/4/21 14:02
 **/
@Component
public class MD5Utils {

    private static final String salt = "bistu";



    /**
     * 对输入的密码进行加密
     * @param userPassword 用户输入的密码
     * @return 加密后的密码
     */
    public static String Encryption(String userPassword) {
        String md5Password;
        userPassword = DigestUtils.md5DigestAsHex(userPassword.getBytes());
        userPassword = salt.charAt(0) + salt.charAt(1) + userPassword + salt.charAt(2) + userPassword.charAt(3) + userPassword.charAt(4);
        md5Password = DigestUtils.md5DigestAsHex(userPassword.getBytes());
        return md5Password;
    }

}
