package com.example.campus_second_hand_trading_platform.dao.Repository;

import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.mapper.UserMapper;
import com.example.campus_second_hand_trading_platform.domain.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 获取所有用户信息
     * @return
     */
    public List<UserVo> getAllUser() {

        return userMapper.getAllUser();
    }

    /**
     * 修改用户的状态为正常
     * @param userName
     * @return
     */
    public boolean updateUserState(String userName) {

        if(userMapper.updateUserState(userName) == 1) return true;
        return false;
    }
}
