package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.Administrators;
import com.example.campus_second_hand_trading_platform.dao.mapper.AdministratorsMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.security.auth.login.LoginContext;

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
public class AdministratorsController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    AdministratorsMapper administratorsMapper;

    @GetMapping
    public String  Login(HttpServletRequest request){
        Administrators administrators =  administratorsMapper.selectById("1");
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("userLogin", administrators);
        return "1";
    }
}
