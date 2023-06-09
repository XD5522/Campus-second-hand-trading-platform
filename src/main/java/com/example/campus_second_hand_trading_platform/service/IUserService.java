package com.example.campus_second_hand_trading_platform.service;

import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.campus_second_hand_trading_platform.domain.dto.UserDto;
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

    public List<UserVo> getAuditUser();

    public List<UserVo> getAuditMerchant();

    public boolean passUser(String userName);

    public boolean noPassUser(String userName);

    public boolean banUser(String userName);

    public boolean deleteUser(String userName);

    public List<UserVo> searchUser(String searchText, int start, int pageSize);

    public List<UserVo> searchAuditUser(String searchText, int start, int pageSize);

    public boolean editMessage(int id, String userName, String name, String city, String type);

    public boolean resetPassword(int userId);
}
