package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.mapper.UserMapper;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.List;

/**2020011236
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2023-04-04
 */
@Service("UserServiceImpl")



public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> getByName(String name){
        return userMapper.getByName(name);
    }
}
