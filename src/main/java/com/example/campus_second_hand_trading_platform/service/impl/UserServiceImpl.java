package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.example.campus_second_hand_trading_platform.dao.Repository.UserRepository;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import com.example.campus_second_hand_trading_platform.dao.mapper.UserMapper;
import com.example.campus_second_hand_trading_platform.domain.dto.UserDto;
import com.example.campus_second_hand_trading_platform.domain.vo.UserVo;
import com.example.campus_second_hand_trading_platform.service.IUserAccountService;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserAccountService iUserAccountService;

    public List<User> getByName(String name){
        return userMapper.getByName(name);
    }

    /**
     * 通过用户名获取用户账户信息
     * @param userName 用户名
     * @return
     */
    public User getByUserName(String userName) {

        return userRepository.getByUserName(userName);
    }

    /**
     * 通过手机号获取用户账户信息
     * @param phone 手机号
     * @return
     */
    public User getByPhone(String phone) {

        return userRepository.getByPhone(phone);
    }

    /**
     * 检查是否存在使用该用户名的用户账户
     * @param userName 用户名
     * @return
     */
    public boolean checkUserName(String userName) {

        User user = getByUserName(userName);

        //判断找到的用户信息是否为空
        if(user != null) return true;
        return false;
    }

    /**
     * 检查是否存在使用该手机号的用户账户
     * @param phone 手机号
     * @return
     */
    public boolean checkPhone(String phone) {

        User user = getByPhone(phone);

        //判断找到的用户信息是否为空
        if(user != null) return true;
        return false;

    }

    /**
     * 获取所有用户信息
     * @return
     */
    public List<UserVo> getAllUser() {

        return userRepository.getAllUser();
    }

    /**
     * 获取待审核用户信息
     * @return
     */
    public List<UserVo> getAuditUser() {

        return userRepository.getAuditUser();
    }

    /**
     * 获取待审核商家信息
     * @return
     */

    public List<UserVo> getAuditMerchant() {
        return userRepository.getAuditMerchant();
    }

    /**
     * 修改用户的状态为正常
     * @param userName
     * @return
     */
    public boolean passUser(String userName) {

        return userRepository.passUser(userName);
    }

    /**
     * 修改用户的状态为审核未通过
     * @param userName
     * @return
     */
    public boolean noPassUser(String userName) {

        return userRepository.noPassUser(userName);
    }

    /**
     * 修改用户的状态为封禁
     * @param userName
     * @return
     */
    public boolean banUser(String userName) {

        return userRepository.banUser(userName);
    }

    /**
     * 删除用户
     * @param userName
     * @return
     */
    public boolean deleteUser(String userName) {

        return userRepository.deleteUser(userName);
    }

    /**
     * 分页查询含有搜索框输入的用户名的用户
     * @param searchText
     * @param start
     * @param pageSize
     * @return
     */
    public List<UserVo> searchUser(String searchText, int start, int pageSize) {

        return userRepository.searchUser(searchText, start, pageSize);
    }

    /**
     * 分页查询含有搜索框输入的用户名的待审核用户
     * @param searchText
     * @param start
     * @param pageSize
     * @return
     */
    public List<UserVo> searchAuditUser(String searchText, int start, int pageSize) {

        return userRepository.searchAuditUser(searchText, start, pageSize);
    }

    public boolean editMessage(int id, String userName, String name, String city, String type) {
        User user = new User();
        user.setUserName(userName);
        user.setName(name);
        user.setCity(city);
        user.setType(type);
        user.setId(id);
        return userRepository.editMessage(user);
    }

    public boolean resetPassword(int userId) {

        String resetPassword = "66dab74237d0253d9516b6240a488f44";

        return userRepository.resetPassword(userId, resetPassword);
    }

}
