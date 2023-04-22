package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
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

    @Select("select * from user_account where user_account = #{userName}")
    public UserAccount getByUserName(@Param("userName") String userName);
}