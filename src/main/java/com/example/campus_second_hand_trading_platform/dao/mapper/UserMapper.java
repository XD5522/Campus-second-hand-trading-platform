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
    @Insert("insert into user(user_name,name,type,city,phone,gender,bank_card,email,license) " +
            "values(#{user.userName},#{user.name},#{user.type},#{user.city},#{user.phone}," +
            "#{user.gender},#{user.bankCard},#{user.email},#{user.license})")
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
                    @Result(column = "city", property = "city"),
                    @Result(column = "img", property = "img"),
            }
    )
    @Select("select * from user where flag = 0 and (state != 'audit' and state != '审核未通过')")
    public List<UserVo> getAllUser();

    /**
     * 获取待审核用户
     * @return
     */
    @Results(
            {
                    @Result(column = "id", property = "id"),
                    @Result(column = "user_name", property = "userName"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "type", property = "type"),
                    @Result(column = "state", property = "state"),
                    @Result(column = "city", property = "city"),
                    @Result(column = "img", property = "img"),
            }
    )
    @Select("select * from user where flag = 0 and (state = 'audit' or state = '审核未通过') ")
    public List<UserVo> getAuditUser();

    /**
     * 修改用户的状态为正常
     * @param userName
     * @return
     */
    @Update("update user set state = '正常' where user_name = #{userName}")
    public int passUser(@Param("userName") String userName);

    /**
     * 修改用户的状态为审核未通过
     * @param userName
     * @return
     */
    @Update("update user set state = '审核未通过' where user_name = #{userName}")
    public int noPassUser(@Param("userName") String userName);

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

    /**
     * 分页查询含有搜索框输入的用户名的用户
     * @param searchText
     * @param start
     * @param pageSize
     * @return
     */

    @Results(
            {
                    @Result(column = "id", property = "id"),
                    @Result(column = "user_name", property = "userName"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "type", property = "type"),
                    @Result(column = "state", property = "state"),
                    @Result(column = "city", property = "city"),
                    @Result(column = "img", property = "img"),
            }
    )
    @Select("select * from user where (user_name like CONCAT('%', #{searchText}, '%') and flag = 0 and (state != 'audit' and state != '审核未通过')) limit #{start}, #{pageSize}")
    public List<UserVo> searchUser(@Param("searchText") String searchText, @Param("start") int start, @Param("pageSize") int pageSize);

    /**
     * 分页查询含有搜索框输入的用户名的待审核用户
     * @param searchText
     * @param start
     * @param pageSize
     * @return
     */

    @Results(
            {
                    @Result(column = "id", property = "id"),
                    @Result(column = "user_name", property = "userName"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "type", property = "type"),
                    @Result(column = "state", property = "state"),
                    @Result(column = "city", property = "city"),
                    @Result(column = "img", property = "img"),
            }
    )
    @Select("select * from user where (user_name like CONCAT('%', #{searchText}, '%') and flag = 0 and (state = 'audit' or state = '审核未通过')) limit #{start}, #{pageSize}")
    public List<UserVo> searchAuditUser(@Param("searchText") String searchText, @Param("start") int start, @Param("pageSize") int pageSize);

    public void buyProduct(int id,double price);
    public void setWallet(int id,double price);

    public void setScore(int id,int score);

    @Update("update user set " +
            "user_name = #{user.userName}, " +
            "name = #{user.name}, " +
            "city = #{user.city}, " +
            "type = #{user.type} " +
            "where id = #{user.id}")
    public int editMessage(@Param("user") User user);

    @Update("update user_account set user_password = #{resetPassword} where user_id = #{userId}")
    public int resetPassword(@Param("userId") int userId, @Param("resetPassword") String resetPassword);
}
