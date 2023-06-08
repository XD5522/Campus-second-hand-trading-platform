package com.example.campus_second_hand_trading_platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.domain.vo.RecordVo;

import java.util.List;

/**
 * @author cc
 */
public interface WalletService {

    void reCharge(int id,double num);
    void getMoney(int id,double num);
    List<RecordVo> getMoney(int id);
    List<RecordVo> getRecharge(int id);
    List<RecordVo> getPayout(int id);
    List<RecordVo> getIncome(int id);
}
