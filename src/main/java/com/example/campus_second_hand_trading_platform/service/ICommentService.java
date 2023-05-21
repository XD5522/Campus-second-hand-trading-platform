package com.example.campus_second_hand_trading_platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.campus_second_hand_trading_platform.dao.entity.Comment;
import com.example.campus_second_hand_trading_platform.domain.vo.CommentVo;

import java.util.List;

public interface ICommentService extends IService<Comment> {
    /**
     * 通过产品id搜索对应评论
     * @param product_id
     * @return List<Comment>
     */
    public List<CommentVo> GetListByPD(int product_id);
}
