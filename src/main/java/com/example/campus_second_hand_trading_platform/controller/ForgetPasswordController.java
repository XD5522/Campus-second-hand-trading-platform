package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.domain.dto.UserDto;
import com.example.campus_second_hand_trading_platform.service.IEmailService;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @Description 忘记密码控制器
 * @Author qionghua
 * @Date 2023/5/16 11:08
 **/
@Slf4j
@RequestMapping("/api/forget_password")
@RestController
@CrossOrigin
public class ForgetPasswordController {

    private IEmailService iEmailService;

    /**
     * 忘记密码
     * @param userDto
     * @return
     */
    public String ForgetPassword(UserDto userDto) {



        return "";
    }

}
