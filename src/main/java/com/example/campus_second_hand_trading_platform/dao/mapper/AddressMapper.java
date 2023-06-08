package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.campus_second_hand_trading_platform.dao.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cc
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
    public List<Address> getAddress(int id);

}
