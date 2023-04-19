package com.example.campus_second_hand_trading_platform.dao.Repository;


import com.example.campus_second_hand_trading_platform.dao.entity.Administrators;
import com.example.campus_second_hand_trading_platform.dao.mapper.AdminMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class AdminRepository {
    @Autowired
    AdminMapper adminMapper;
    public Administrators getByAccount(String account){
        return adminMapper.getByAccount(account);
    }
}
