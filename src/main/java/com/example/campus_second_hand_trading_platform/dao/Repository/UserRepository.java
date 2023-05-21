package com.example.campus_second_hand_trading_platform.dao.Repository;

import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @Description
 * @Author qionghua
 * @Date 2023/5/7 13:55
 **/
@Repository
public class UserRepository {
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过用户名获取用户信息
     * @param userName 用户名
     * @return
     */
    public User getByUserName(String userName) {

        return userMapper.getByUserName(userName);
    }

    /**
     * 通过手机号获取用户信息
     * @param phone 手机号
     * @return
     */
    public User getByPhone(String phone) {

        return userMapper.getByPhone(phone);
    }

    /**
     * 添加一个用户
     * @param user 用户信息
     * @return
     */
    public int insertUser(User user) {

        return userMapper.insertUser(user);
    }
}
