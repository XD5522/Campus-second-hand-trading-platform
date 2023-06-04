package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.campus_second_hand_trading_platform.dao.entity.Car;
import com.example.campus_second_hand_trading_platform.dao.mapper.CarMapper;
import com.example.campus_second_hand_trading_platform.domain.vo.CarVo;
import com.example.campus_second_hand_trading_platform.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarServiceImpl extends ServiceImpl<CarMapper,Car> implements CarService {
    @Autowired
    CarMapper carMapper;
    @Override
    public IPage<CarVo> getCarByUserId(int id,int current,int num) {

        IPage<CarVo> page = new Page<CarVo>(current,num);

        log.info(String.valueOf(id));


        return carMapper.getCarByUserId(page,id);
    }


}
