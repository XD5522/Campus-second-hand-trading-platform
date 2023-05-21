package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.campus_second_hand_trading_platform.dao.Repository.UserAccountRepository;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import com.example.campus_second_hand_trading_platform.dao.mapper.UserAccountMapper;
import com.example.campus_second_hand_trading_platform.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @Description 用户登录服务实现类
 * @Author qionghua
 * @Date 2023/4/20 11:53
 **/

@Service
public class UserLoginServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserLoginService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    /**
     * 通过用户名获取账户信息
     * @param userName 用户输入的用户名
     * @return 账户信息
     */
    public UserAccount getByUserName(String userName)
    {
        return userAccountRepository.getByUserName(userName);
    }
}
