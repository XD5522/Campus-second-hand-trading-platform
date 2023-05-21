package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import com.example.campus_second_hand_trading_platform.domain.dto.LoginDataDto;
import com.example.campus_second_hand_trading_platform.service.IUserLoginService;
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
@RequestMapping("/api/login")
@RestController
@CrossOrigin
public class UserLoginController {

    @Autowired
    private IUserLoginService iUserLoginService;

    @Autowired
    private MD5Utils md5Utils;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 用户登录
     * @param loginDataDto 前端传来的登陆数据
     * @return token令牌
     */
    @PostMapping()
    public String Login(@RequestBody LoginDataDto loginDataDto){

        //MD5加密
        String md5Password = md5Utils.Encryption(loginDataDto.getUserPassword());

        //加密后检查是否存在该用户名和密码的账户
        UserAccount userAccount = iUserLoginService.getByUserName(loginDataDto.getUserName());

        String token = "";

        if(userAccount == null) {
            //用户不存在
            log.info("用户不存在，登陆失败");
        }
        else {
            //用户存在，开始验证密码
            log.info("用户存在");
            if(md5Password.equals(userAccount.getUserPassword())) {
                //生成token
                token = jwtUtils.saveToken(userAccount.getUserId().toString(), userAccount.getUserAccount(), 3600L);
                log.info(token.toString());
            }
            else {
                log.info("密码不正确");
            }
        }
        log.info(loginDataDto.toString());

        return token;
    }
}
