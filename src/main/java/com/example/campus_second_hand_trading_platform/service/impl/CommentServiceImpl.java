package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.campus_second_hand_trading_platform.dao.entity.Comment;
import com.example.campus_second_hand_trading_platform.dao.mapper.CommentMapper;
import com.example.campus_second_hand_trading_platform.domain.vo.CommentVo;
import com.example.campus_second_hand_trading_platform.service.ICommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper,Comment> implements ICommentService{
    @Autowired
    CommentMapper mapper;
    @Override
    public List<CommentVo> GetListByPD(int product_id) {
        return mapper.GetListByPD(product_id);
    }
}
