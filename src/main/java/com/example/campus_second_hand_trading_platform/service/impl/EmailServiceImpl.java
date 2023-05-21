package com.example.campus_second_hand_trading_platform.service.impl;

import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.service.IUserService;

/**
 * TODO
 *
 * @Description 邮箱服务实现类
 * @Author qionghua
 * @Date 2023/5/16 11:46
 **/
public class EmailServiceImpl {

    private IUserService iUserService;

    public boolean checkEmail(String userName, String email) {

        if(iUserService.checkUserName(userName)) {

            User user = iUserService.getByUserName(userName);
            if(user.getEmail().equals(email)) return true;
            return false;
        }
        return false;
    }

}
