package com.example.campus_second_hand_trading_platform.service;

import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.campus_second_hand_trading_platform.domain.vo.UserVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cc
 * @since 2023-04-04
 */

public interface IUserService extends IService<User> {
    public List<User> getByName(String name);

    public User getByUserName(String userName);

    public User getByPhone(String phone);

    public boolean checkUserName(String userName);

    public boolean checkPhone(String phone);

    public List<UserVo> getAllUser();

    public boolean updateUserState(String userName);
}
