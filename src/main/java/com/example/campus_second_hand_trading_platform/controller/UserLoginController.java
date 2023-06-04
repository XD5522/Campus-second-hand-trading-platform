package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import com.example.campus_second_hand_trading_platform.domain.dto.LoginDataDto;
import com.example.campus_second_hand_trading_platform.service.IUserAccountService;
import com.example.campus_second_hand_trading_platform.service.IUserLoginService;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import com.example.campus_second_hand_trading_platform.utils.JwtUtils;
import com.example.campus_second_hand_trading_platform.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO Token验证实现
 *
 * @Description 用户登录的控制器
 * @Author qionghua
 * @Date 2023/4/20 11:41
 **/

@Slf4j
@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserLoginController {

    @Autowired
    private IUserLoginService iUserLoginService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IUserAccountService iUserAccountService;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 用户登录
     * @param loginDataDto 前端传来的登陆数据
     * @return 带token令牌的信息
     */
    @PostMapping("login")
    public CommonResult<?> Login(@RequestBody LoginDataDto loginDataDto){
        //MD5加密
        String md5Password = MD5Utils.Encryption(loginDataDto.getUserPassword());
        log.info(md5Password.toString());
        //加密后检查是否存在该用户名和密码的账户

        User user = iUserService.getByUserName(loginDataDto.getUserName());
        if(user == null) {
            //用户不存在
            log.info("用户不存在，登陆失败");
            return CommonResult.failed();
        }

        UserAccount userAccount = iUserAccountService.getById(user.getId());

        String token = "";

        if(userAccount == null) {
            //用户账户不存在
            log.info("用户账户不存在，登陆失败");
            return CommonResult.failed();
        }
        else {
            //用户存在，开始验证密码
            log.info("用户存在");
            if(md5Password.equals(userAccount.getUserPassword())) {
                //生成token
                token = jwtUtils.saveToken(user, userAccount.getUserAccount(), 3600L);

            }
            else {
                log.info("密码不正确");
                return CommonResult.failed();
            }
        }
        log.info(loginDataDto.toString());
        //log.info(jwtUtils.getUserAccountByToken(token).toString());
        return CommonResult.success(token);
    }
}
