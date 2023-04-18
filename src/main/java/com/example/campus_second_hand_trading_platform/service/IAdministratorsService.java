package com.example.campus_second_hand_trading_platform.service;

import com.example.campus_second_hand_trading_platform.dao.entity.Administrators;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cc
 * @since 2023-04-17
 */
public interface IAdministratorsService extends IService<Administrators> {
    public Administrators getByAccount(String account);
}
