package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.example.campus_second_hand_trading_platform.dao.entity.Administrators;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2023-04-17
 */
@Mapper
public interface AdministratorsMapper extends BaseMapper<Administrators> {
    @Select("select * from administrators where admin_account = #{key}")
    public Administrators getByAccount(@Param("key") String account);
}
