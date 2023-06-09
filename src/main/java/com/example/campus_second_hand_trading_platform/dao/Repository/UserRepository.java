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
     * 获取待审核用户信息
     * @return
     */
    public List<UserVo> getAuditUser() {

        return userMapper.getAuditUser();
    }

    /**
     * 获取待审核商家信息
     * @return
     */
    public List<UserVo> getAuditMerchant() {

        return userMapper.getAuditMerchant();
    }

    /**
     * 修改用户的状态为正常
     * @param userName
     * @return
     */
    public boolean passUser(String userName) {

        if(userMapper.passUser(userName) == 1) return true;
        return false;
    }

    /**
     * 修改用户的状态为审核未通过
     * @param userName
     * @return
     */
    public boolean noPassUser(String userName) {

        if(userMapper.noPassUser(userName) == 1) return true;
        return false;
    }

    /**
     * 修改用户的状态为封禁
     * @param userName
     * @return
     */
    public boolean banUser(String userName) {

        if(userMapper.banUser(userName) == 1) return true;
        return false;
    }

    /**
     * 删除用户
     * @param userName
     * @return
     */
    public boolean deleteUser(String userName) {

        if(userMapper.deleteUser(userName) == 1) return true;
        return false;
    }

    /**
     * 分页查询含有搜索框输入的用户名的用户
     * @param searchText
     * @param start
     * @param pageSize
     * @return
     */
    public List<UserVo> searchUser(String searchText, int start, int pageSize) {

        return userMapper.searchUser(searchText, start, pageSize);
    }

    /**
     * 分页查询含有搜索框输入的用户名的待审核用户
     * @param searchText
     * @param start
     * @param pageSize
     * @return
     */
    public List<UserVo> searchAuditUser(String searchText, int start, int pageSize) {

        return userMapper.searchAuditUser(searchText, start, pageSize);
    }

    /**
     * 编辑用户的信息
     * @param user
     * @return
     */

    public boolean editMessage(User user) {

        return userMapper.editMessage(user) == 1;
    }

    /**
     * 重置用户所在账户的密码
     * @param userId
     * @return
     */
    public boolean resetPassword(int userId, String resetPassword) {

        return userMapper.resetPassword(userId, resetPassword) == 1;
    }
}
