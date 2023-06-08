package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.dao.mapper.UserMapper;
import com.example.campus_second_hand_trading_platform.dao.mapper.WalletMapper;
import com.example.campus_second_hand_trading_platform.domain.vo.RecordVo;
import com.example.campus_second_hand_trading_platform.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cc
 */

@Service
@Slf4j
public class WalletServiceImpl implements WalletService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    WalletMapper walletMapper;

    @Override
    public void reCharge(int id, double num) {
        double wallet = userMapper.selectById(id).getWallet();
        wallet = wallet+num;
        userMapper.setWallet(id,wallet);

    }

    @Override
    public void getMoney(int id, double num) {
        double wallet = userMapper.selectById(id).getWallet();
        wallet = wallet-num;
        userMapper.setWallet(id,wallet);
    }

    @Override
    public List<RecordVo> getMoney(int id) {
        return walletMapper.getMoney(id);
    }

    @Override
    public List<RecordVo> getRecharge(int id) {
        return walletMapper.getRecharge(id);
    }

    @Override
    public List<RecordVo> getPayout(int id) {
        return walletMapper.getPayout(id);
    }

    @Override
    public List<RecordVo> getIncome(int id) {
        return walletMapper.getIncome(id);
    }
}
