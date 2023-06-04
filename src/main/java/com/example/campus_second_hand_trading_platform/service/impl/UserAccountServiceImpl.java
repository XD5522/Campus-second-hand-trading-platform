package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.campus_second_hand_trading_platform.dao.Repository.UserAccountRepository;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import com.example.campus_second_hand_trading_platform.dao.mapper.UserAccountMapper;
import com.example.campus_second_hand_trading_platform.service.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @Description
 * @Author qionghua
 * @Date 2023/5/22 22:43
 **/
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;
    public UserAccount getByUserId(Integer id) {
        return userAccountRepository.getByUserId(id);
    }

    public UserAccount getByUserAccount(String userAccount) {
        return userAccountRepository.getByUserAccount(userAccount);
    }
}