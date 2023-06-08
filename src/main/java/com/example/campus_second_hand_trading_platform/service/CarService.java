package com.example.campus_second_hand_trading_platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.campus_second_hand_trading_platform.dao.entity.Car;
import com.example.campus_second_hand_trading_platform.domain.vo.CarVo;

import java.util.List;

/**
 * @author cc
 */
public interface CarService extends IService<Car> {
    IPage<CarVo> getCarByUserId(int id,int current,int num);
    List<CarVo> getCarByIds(List<Integer> ids);
}
