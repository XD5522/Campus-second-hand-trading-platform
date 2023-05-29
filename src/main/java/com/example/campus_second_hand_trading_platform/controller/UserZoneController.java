package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.domain.vo.UserMsgVo;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import com.example.campus_second_hand_trading_platform.dao.entity.Product;
import com.example.campus_second_hand_trading_platform.domain.dto.AddProductDTO;
import com.example.campus_second_hand_trading_platform.service.IAddProductService;
import com.example.campus_second_hand_trading_platform.utils.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户个人中心的功能接口
 */
@Slf4j
@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserZoneController {
    @Autowired
    IAddProductService addProductService;
    @Autowired
    IUserService userService;

    @PostMapping("/AddNewProduct")
    public CommonResult AddNewProduct(@RequestBody AddProductDTO data){
        Product product = new Product();
        BeanUtils.copyProperties(data,product);
        log.info(product.toString());

        if(addProductService.save(product)){
            return CommonResult.success(product);
        }else{
            log.debug("插入失败",product);
            return CommonResult.failed("插入失败");
        }
    }

    /**
     * 通过id获取用户的基本信息
     * 用于用户主页的显示
     * @param user_id
     * @return
     */
    @GetMapping("getUserMsg")
    public CommonResult getUserMsgByid(@RequestParam int user_id){
        User user = userService.getById(user_id);
        UserMsgVo userMsgVo = new UserMsgVo();
        BeanUtils.copyProperties(user,userMsgVo);
        return CommonResult.success(userMsgVo);
    }
}
