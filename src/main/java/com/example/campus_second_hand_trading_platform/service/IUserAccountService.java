package com.example.campus_second_hand_trading_platform.service;

import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;

/**
 * TODO
 *
 * @Description
 * @Author qionghua
 * @Date 2023/5/22 22:42
 **/
public interface IUserAccountService {

    public UserAccount getByUserId(Integer id);

    public UserAccount getByUserAccount(String userAccount);
}
