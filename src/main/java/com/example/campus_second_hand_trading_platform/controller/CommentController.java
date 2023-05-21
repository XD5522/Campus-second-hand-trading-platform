package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.Comment;
import com.example.campus_second_hand_trading_platform.domain.vo.CommentVo;
import com.example.campus_second_hand_trading_platform.service.ICommentService;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    ICommentService service;

    /**
     * 新增评论
     * @param commentdto
     * @return 添加成功与否
     */
    @PostMapping("/addComment")
    public CommonResult<?> AddComent(@RequestBody Comment commentdto){
        if(service.save(commentdto)){
            return CommonResult.success(commentdto);
        }else{
            log.debug("add comment fail",commentdto);
            return CommonResult.failed("add comment fail");
        }
    }

    @GetMapping("/GetList")
    public CommonResult<List<CommentVo>> GetListByPD(@RequestParam int product_id){
        return CommonResult.success(service.GetListByPD(product_id));
    }
}
