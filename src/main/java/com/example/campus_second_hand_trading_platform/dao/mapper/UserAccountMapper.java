package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * TODO
 *
 * @Description 登陆数据的Mapper接口
 * @Author qionghua
 * @Date 2023/4/20 11:59
 **/
@Mapper
public interface UserAccountMapper extends BaseMapper<UserAccount> {

    /**
     * 根据用户名查找用户账户
     * @param userName
     * @return
     */
    public UserAccount getByUserName(String userName);

    /**
     * 添加一个用户账户
     * @param userAccount
     * @return
     */
    @Insert("insert into user_account(user_id,user_account,user_password) " +
            "values(#{userAccount.userId},#{userAccount.userAccount},#{userAccount.userPassword})")
    public int insertUserAccount(@Param("userAccount") UserAccount userAccount);
}