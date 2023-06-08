package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.domain.vo.OrderVo;
import com.example.campus_second_hand_trading_platform.domain.vo.RecordVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cc
 */
@Mapper
public interface WalletMapper {
    List<RecordVo> getMoney(int id);
    List<RecordVo> getRecharge(int id);
    List<RecordVo> getPayout(int id);
    List<RecordVo> getIncome(int id);
}
