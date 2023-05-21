package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.domain.dto.RegisterDataDto;
import com.example.campus_second_hand_trading_platform.service.IUserRegisterService;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import com.example.campus_second_hand_trading_platform.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO 用户注册控制器编写
 *
 * @Description 用户注册控制器
 * @Author qionghua
 * @Date 2023/4/23 20:37
 **/
@Slf4j
@RequestMapping("/api/register")
@RestController
@CrossOrigin
public class UserRegisterController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IUserRegisterService iUserRegisterService;

    @Autowired
    private MD5Utils md5Utils;

    /**
     * 用户注册
     * @param registerDataDto
     * @return
     */
    @PostMapping()
    public String Register(@RequestBody RegisterDataDto registerDataDto) {

        String username = registerDataDto.getUserName();

        String phone = registerDataDto.getPhone();

        //检查是否存在输入的用户名或密码
        if(!iUserService.checkUserName(username) && !iUserService.checkPhone(phone)) {

            log.info(registerDataDto.toString());

            // 将注册输入的密码进行md5加密
            String md5PassWord = MD5Utils.Encryption(registerDataDto.getPassword());
            registerDataDto.setPassword(md5PassWord);

            iUserRegisterService.insertUser(registerDataDto);
            iUserRegisterService.insertUserAccount(registerDataDto);
            log.info("注册成功");
        }
        else if(iUserService.checkUserName(username)) {

            log.info("该用户名已经被注册过");
        }
        else if(iUserService.checkPhone(phone)) {

            log.info("该手机号已经被注册过");
        }

        return "";
    }

}
