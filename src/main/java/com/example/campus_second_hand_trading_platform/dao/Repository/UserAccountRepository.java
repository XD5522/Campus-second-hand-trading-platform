package com.example.campus_second_hand_trading_platform.dao.Repository;

import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import com.example.campus_second_hand_trading_platform.dao.mapper.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @Description
 * @Author qionghua
 * @Date 2023/4/20 17:48
 **/
@Repository
public class UserAccountRepository {

    @Autowired
    private UserAccountMapper userAccountMapper;

    /**
     * 通过用户输入的登陆数据获取
     * @param userName 用户输入的用户名
     * @return 账户信息
     */
    public UserAccount getByUserName(String userName) {

        return userAccountMapper.getByUserName(userName);
    }

    /**
     * 添加一个用户账户
     * @param userAccount 用户账户信息
     * @return
     */
    public int insertUserAccount(UserAccount userAccount) {

        return userAccountMapper.insertUserAccount(userAccount);
    }
}
