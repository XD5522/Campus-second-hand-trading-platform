package com.example.campus_second_hand_trading_platform.dao.Repository;

import com.example.campus_second_hand_trading_platform.dao.entity.User;
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
     * @param id 用户的id
     * @return 账户信息
     */
    public UserAccount getById(Integer id) {

        return userAccountMapper.getById(id);
    }

    /**
     * 通过用户的账户名来获取用户账户信息
     * @param userAccount
     * @return
     */
    public UserAccount getByUserAccount(String userAccount) {

        return userAccountMapper.getByUserAccount(userAccount);
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
