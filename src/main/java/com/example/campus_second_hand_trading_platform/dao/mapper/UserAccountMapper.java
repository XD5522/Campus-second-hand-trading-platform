package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import org.apache.ibatis.annotations.*;

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
     * 根据用户id查找用户账户
     * @param id
     * @return
     */
    @Select("select * from user_account where user_id = #{id}")
    public UserAccount getByUserId(@Param("id") int id);

    @Select("select * from user_account where user_account = #{userAccount}")
    public UserAccount getByUserAccount(@Param("userAccount") String userAccount);

    /**
     * 添加一个用户账户
     * @param userAccount
     * @return
     */
    @Insert("insert into user_account(user_id,user_account,user_password) " +
            "values(#{userAccount.userId},#{userAccount.userAccount},#{userAccount.userPassword})")
    public int insertUserAccount(@Param("userAccount") UserAccount userAccount);

    @Update("update user_account set flag = 1 where user_id = #{id}")
    public int deleteUserAccount(@Param("id") int userId);
}