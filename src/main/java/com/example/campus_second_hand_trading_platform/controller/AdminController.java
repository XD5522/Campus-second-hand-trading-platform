package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import com.example.campus_second_hand_trading_platform.domain.dto.UserDto;
import com.example.campus_second_hand_trading_platform.domain.vo.UserVo;
import com.example.campus_second_hand_trading_platform.service.IProductService;
import com.example.campus_second_hand_trading_platform.service.IUserAccountService;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @Description 管理员控制器
 * @Author qionghua
 * @Date 2023/6/6 20:18
 **/
@Slf4j
@RequestMapping("/admin")
@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    private IUserService iUserService;

    @Autowired
    private IUserAccountService iUserAccountService;

    @Autowired
    private IProductService iProductService;

    @GetMapping("/getUserData")
    public CommonResult<List<UserVo>> getAllUser() {
        List<UserVo> data;
        data = iUserService.getAllUser();
        return CommonResult.success(data);
    }

    /**
     * 用户通过审核
     * @param userName
     * @return
     */
    @PostMapping("/passUser")
    public CommonResult<?> passUser(@RequestParam String userName) {

        log.info(userName.toString());

        if(iUserService.passUser(userName)) {
            log.info("审核通过");
            return CommonResult.success("审核通过");
        }
        return CommonResult.failed();
    }

    @PostMapping("/banUser")
    public CommonResult<?> banUser(@RequestParam String userName) {

        log.info(userName.toString());

        if(iUserService.banUser(userName)) {
            log.info("封禁成功");
            return CommonResult.success("封禁成功");
        }
        return CommonResult.failed();
    }

    @PostMapping("/deleteUser")
    public CommonResult<?> deleteUser(@RequestParam String userName) {

        log.info(userName.toString());

        User user;
        user = iUserService.getByUserName(userName);

        if(iUserService.deleteUser(userName) && iUserAccountService.deleteUserAccount(user.getId())) {
            log.info("删除成功");
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed();
    }
}
