package com.example.campus_second_hand_trading_platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;

/**
 * TODO
 *
 * @Description 用户登录服务类
 * @Author qionghua
 * @Date 2023/4/20 11:39
 **/
public interface IUserLoginService extends IService<UserAccount> {

    public UserAccount getByUserName(String userName);
}
