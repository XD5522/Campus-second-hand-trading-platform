package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.dao.entity.Car;
import com.example.campus_second_hand_trading_platform.domain.vo.CarVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 16646
 */
@Mapper
public interface CarMapper extends BaseMapper<Car> {
    IPage<CarVo> getCarByUserId(IPage<CarVo> page, int userId);

}
