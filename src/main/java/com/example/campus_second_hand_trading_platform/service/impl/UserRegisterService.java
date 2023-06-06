package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.campus_second_hand_trading_platform.dao.Repository.UserAccountRepository;
import com.example.campus_second_hand_trading_platform.dao.Repository.UserRepository;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import com.example.campus_second_hand_trading_platform.dao.mapper.UserMapper;
import com.example.campus_second_hand_trading_platform.domain.dto.RegisterDataDto;
import com.example.campus_second_hand_trading_platform.service.IUserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 用户注册服务实现类编写
 *
 * @Description 用户注册服务实现类
 * @Author qionghua
 * @Date 2023/4/23 20:40
 **/
@Service
public class UserRegisterService extends ServiceImpl<UserMapper, User> implements IUserRegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    /**
     * 根据用户输入的注册信息添加用户
     * @param registerDataDto 用户输入的注册信息
     * @return
     */
    public int insertUser(RegisterDataDto registerDataDto) {

        User user = new User(registerDataDto);

        return userRepository.insertUser(user);

    }

    /**
     * 根据用户输入的注册信息添加用户账户
     * @param registerDataDto 用户输入的注册信息
     * @return
     */
    public int insertUserAccount(RegisterDataDto registerDataDto) {

        User user;
        user = userRepository.getByUserName(registerDataDto.getUserName());

        int userId;
        userId = user.getId();

        UserAccount userAccount = new UserAccount(registerDataDto, userId);

        return userAccountRepository.insertUserAccount(userAccount);

    }

}
