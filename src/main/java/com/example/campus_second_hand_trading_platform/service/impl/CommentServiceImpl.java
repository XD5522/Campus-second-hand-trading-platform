package com.example.campus_second_hand_trading_platform.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Override
    public IPage<CommentVo> GetListByUser(int user_id, int pageSize, int pageNum) {
        IPage<CommentVo> page = new Page<>(pageNum,pageSize);
        return mapper.GetListByUser(page,user_id);
    }

    @Override
    public IPage<CommentVo> GetPersonComment(int user_id, int pageSize, int pageNum, String state) {
        IPage<CommentVo> page = new Page<>(pageNum,pageSize);
        if(state.equals("ER")) return mapper.GetPersonCommentA(page,user_id);//commenter
        else return mapper.GetPersonCommentB(page,user_id);//commentee
    }

    @Override
    public IPage<CommentVo> getProductComments(int id, int current, int num) {
        IPage<CommentVo> page = new Page<>(current,num);
        return mapper.getProductComments(page,id);
    }


}
