package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.Administrators;
import com.example.campus_second_hand_trading_platform.dao.mapper.AdministratorsMapper;
import com.example.campus_second_hand_trading_platform.domain.dto.AdminDto;
import com.example.campus_second_hand_trading_platform.utils.JWT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
public class AdminController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    AdministratorsMapper administratorsMapper;

    @PostMapping
    public String  Login(HttpServletRequest request, @RequestBody AdminDto adminDto){
        Administrators administrators =  administratorsMapper.selectById("1");
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // 提取 Token，例如将 "Bearer " 后面的部分作为 Token
            String token = authorizationHeader.substring(7);
            // 进行后续处理，例如解析、验证等
            JWT.saveToken(token,30);
        } else {
            return "0";
        }
        System.out.println(administrators.getName());
        return adminDto.getAccount();
    }
    @GetMapping
    public String test(HttpServletRequest request,@RequestBody AdminDto adminDto){
        return "1";
    }

}



