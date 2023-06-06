package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.domain.vo.UserVo;
import org.apache.ibatis.annotations.*;
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

    /**
     * 获取所有用户
     * @return
     */
    @Results(
            {
                    @Result(column = "id", property = "id"),
                    @Result(column = "user_name", property = "userName"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "type", property = "type"),
                    @Result(column = "state", property = "state"),
                    @Result(column = "phone", property = "phone"),
                    @Result(column = "bank_card", property = "bankCard"),
            }
    )
    @Select("select * from user where flag = 0")
    public List<UserVo> getAllUser();

    /**
     * 修改用户的状态为正常
     * @param userName
     * @return
     */
    @Update("update user set state = '正常' where user_name = #{userName}")
    public int passUser(@Param("userName") String userName);

    /**
     * 修改用户的状态为封禁
     * @param userName
     * @return
     */
    @Update("update user set state = '封禁' where user_name = #{userName}")
    public int banUser(@Param("userName") String userName);

    /**
     * 删除用户
     * @param userName
     * @return
     */
    @Update("update user set flag = 1 where user_name = #{userName}")
    public int deleteUser(@Param("userName") String userName);
}
