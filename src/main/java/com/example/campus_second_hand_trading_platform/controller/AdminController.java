package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.Administrators;
import com.example.campus_second_hand_trading_platform.domain.dto.AdminDto;
import com.example.campus_second_hand_trading_platform.service.IAdministratorsService;
import com.example.campus_second_hand_trading_platform.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cc
 * @since 2023-04-17
 */
@RestController
@RequestMapping("/api/admin")
@CrossOrigin
@Slf4j
public class AdminController {


    @Autowired
    IAdministratorsService administratorsService;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping()
    public String  Login(HttpServletRequest request, @RequestBody AdminDto adminDto){
        Administrators administrators =  administratorsService.getByAccount(adminDto.getAccount());
        String token = "";
        if(administrators==null){
            log.info("用户不存在"+adminDto.getAccount());
        }
        else{
            log.info(administrators.getAdminAccount());
            if(administrators.getAdminPassword().equals(adminDto.getPassword()) ){
                log.info("密码正确");
                token = jwtUtils.saveToken(administrators.getId().toString(),adminDto.getAccount(), 3600L);
            }
        }
        log.info(adminDto.toString());
        return token;
    }
    @GetMapping
    public String test(HttpServletRequest request,@RequestBody AdminDto adminDto){
        return "1";
    }

}



