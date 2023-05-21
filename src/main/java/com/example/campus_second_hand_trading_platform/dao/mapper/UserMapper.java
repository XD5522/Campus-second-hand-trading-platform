package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2023-04-03
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户的姓名查找用户
     * @param name
     * @return
     */
    @Select("select * from user where name = #{name}")
    public List<User> getByName(@Param("name") String name);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    @Select("select * from user where user_name = #{user_name}")
    public User getByUserName(@Param("user_name") String userName);

    /**
     * 根据用户的手机号查找用户
     * @param phone
     * @return
     */
    @Select("select * from user where phone = #{phone}")
    public User getByPhone(@Param("phone") String phone);

    /**
     * 插入一个新的用户
     * @param user
     * @return
     */
    @Insert("insert into user(user_name,name,city,phone,gender,bank_card,email) " +
            "values(#{user.userName},#{user.name},#{user.city},#{user.phone}," +
            "#{user.gender},#{user.bankCard},#{user.email})")
    public int insertUser(@Param("user") User user);

}
