package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.Administrators;
import com.example.campus_second_hand_trading_platform.dao.mapper.AdministratorsMapper;
import com.example.campus_second_hand_trading_platform.domain.dto.AdminDto;
import com.example.campus_second_hand_trading_platform.utils.JWT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    RedisTemplate redisTemplate;

    @Autowired
    AdministratorsMapper administratorsMapper;

    @PostMapping()
    public String  Login(HttpServletRequest request, @RequestBody AdminDto adminDto){
        Administrators administrators =  administratorsMapper.getByAccount(adminDto.getUsername());

        log.info(adminDto.toString());
        return "JWT.saveToken(adminDto.getAccount(),3600);";
    }
    @GetMapping
    public String test(HttpServletRequest request,@RequestBody AdminDto adminDto){
        return "1";
    }

}



