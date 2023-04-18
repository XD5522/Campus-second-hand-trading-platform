package com.example.campus_second_hand_trading_platform.service.impl;

import com.example.campus_second_hand_trading_platform.dao.entity.Administrators;
import com.example.campus_second_hand_trading_platform.dao.mapper.AdministratorsMapper;
import com.example.campus_second_hand_trading_platform.service.IAdministratorsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2023-04-17
 */
@Service
public class AdministratorsServiceImpl extends ServiceImpl<AdministratorsMapper, Administrators> implements IAdministratorsService {
    @Autowired
    private AdministratorsMapper administratorsMapper;
    public Administrators getByAccount(String account){
        return administratorsMapper.getByAccount(account);
    }
}
