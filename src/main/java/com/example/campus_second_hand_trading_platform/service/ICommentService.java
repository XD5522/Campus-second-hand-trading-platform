package com.example.campus_second_hand_trading_platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
    public IPage<CommentVo> GetListByUser(int user_id, int pageSize, int pageNum);
    public IPage<CommentVo> GetPersonComment(int user_id,int pageSize, int pageNum,String state);
    public CommentVo GetCommentByOrder(int user_id,int product_id);
}
