package com.example.campus_second_hand_trading_platform.dao.mapper;

import com.example.campus_second_hand_trading_platform.dao.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.campus_second_hand_trading_platform.domain.vo.CommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2023-05-21
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    public List<CommentVo> GetListByPD(int product_id);
}
