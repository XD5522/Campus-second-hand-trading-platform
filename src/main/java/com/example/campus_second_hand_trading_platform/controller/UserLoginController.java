package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.domain.dto.LoginDataDto;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api")
@RestController
@CrossOrigin
public class UserLoginController {
    //TODO 用户登陆功能实现
    @PostMapping("/userlogin")
    String Login(@RequestBody LoginDataDto dto){
        log.info(dto.getUsername());
        log.info(dto.getPassword());
        return dto.getUsername();
    }
}
