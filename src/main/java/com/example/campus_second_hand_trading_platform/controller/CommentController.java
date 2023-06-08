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
@CrossOrigin
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

    /**
     * 通过商品id查找商品的评论列表
     * @param product_id
     * @return
     */
    @GetMapping("/GetList")
    public CommonResult<List<CommentVo>> GetListByPD(@RequestParam int product_id){
        return CommonResult.success(service.GetListByPD(product_id));
    }

    /**
     * 通过用户id搜索用户的商品评论列表(分页查询)
     * @param user_id
     * @param PageSize
     * @param PageNum
     * @return 商品评论列表和分页信息
     */
    @GetMapping("/GetListByUser")
    public CommonResult GetListByUser(@RequestParam int user_id,@RequestParam int PageSize,@RequestParam int PageNum){
        return CommonResult.success(service.GetListByUser(user_id,PageSize,PageNum));
    }

    /**
     * 获取对个人的评价的接口
     * @param user_id
     * @param PageSize
     * @param PageNum
     * @param State
     * @return 评论信息
     */
    @GetMapping("GetPersonComment")
    public CommonResult GetPersonComment(@RequestParam int user_id, @RequestParam int PageSize,
                                         @RequestParam int PageNum, @RequestParam String State){
        return CommonResult.success(service.GetPersonComment(user_id,PageSize,PageNum,State));
    }


    @GetMapping("getProductComments")
    public CommonResult<?> getProductComments(@RequestParam int id,@RequestParam int current,@RequestParam int num){

        try{
            return CommonResult.success(service.getProductComments(id,current,num));
        }catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed("商品评论获取失败");
        }


    }

    /**
     * 通过用户id和商品id搜索评论的接口
     * @param user_id
     * @param product_id
     * @return 评论
     */
    @GetMapping("GetOrderComment")
    public CommonResult GetCommentByOrder(@RequestParam int user_id,@RequestParam int product_id){
        return CommonResult.success(service.GetCommentByOrder(user_id,product_id));
    }
}
