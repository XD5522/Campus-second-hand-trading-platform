package com.example.campus_second_hand_trading_platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import com.example.campus_second_hand_trading_platform.domain.dto.RegisterDataDto;
import org.apache.tomcat.util.buf.UEncoder;

/**
 * TODO 用户注册服务类编写
 *
 * @Description 用户注册服务类
 * @Author qionghua
 * @Date 2023/4/23 20:39
 **/
public interface IUserRegisterService extends IService<User> {

    public int insertUser(RegisterDataDto registerDataDto);

    public int insertUserAccount(RegisterDataDto registerDataDto);

}
