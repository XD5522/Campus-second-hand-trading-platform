package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.Administrators;
import com.example.campus_second_hand_trading_platform.domain.dto.AdminDto;
import com.example.campus_second_hand_trading_platform.service.IAdministratorsService;
import com.example.campus_second_hand_trading_platform.utils.BeanUtils;
import com.example.campus_second_hand_trading_platform.utils.JwtUtils;
import com.example.campus_second_hand_trading_platform.utils.MD5Utils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
* Description:用户登录控制器
* date: 2023/4/22 15:53
* @author cc
* @since JDK17
*/
@RestController
@RequestMapping("/admin/login")
@CrossOrigin
@Slf4j
public class AdminLoginController {


    private final IAdministratorsService administratorsService;
    private final  JwtUtils jwtUtils;

    @Autowired
    public AdminLoginController(IAdministratorsService administratorsService, JwtUtils jwtUtils) {
        this.administratorsService = administratorsService;
        this.jwtUtils = jwtUtils;
    }

    /**
     * 登录接口
     * @param request
     * @param adminDto
     * @return
     *
     */
    @GetMapping()
    public ResponseEntity<?> Login(HttpServletRequest request, @RequestBody AdminDto adminDto){
        Administrators administrators =  administratorsService.getByAccount(adminDto.getAdminAccount());
        String token = "";
        String md5psw = MD5Utils.Encryption(adminDto.getAdminPassword());
        md5psw = MD5Utils.Encryption(md5psw);
        if(administrators==null){
            log.info("用户不存在"+adminDto.getAdminAccount());
        }
        else{
            log.info(administrators.getAdminAccount());
            log.info(md5psw);
            if(administrators.getAdminPassword().equals(md5psw) ){
                log.info("密码正确");
                token = jwtUtils.saveToken(administrators.getId().toString(),adminDto.getAdminAccount(), 3600L);
                log.info(administrators.getId().toString());
            }
        }
        return ResponseEntity.ok(token);
    }
    @PostMapping
    public ResponseEntity<?> test(HttpServletRequest request,@RequestBody AdminDto adminDto){

        if(administratorsService.getByAccount(adminDto.getAdminAccount()) != null){
            return ResponseEntity.ofNullable("账号已存在");
        }
        String md5psw = MD5Utils.Encryption(adminDto.getAdminPassword());
        md5psw = MD5Utils.Encryption(md5psw);
        Administrators administrators = new Administrators();
        log.info(adminDto.toString());
        BeanUtils.copyProperties(adminDto, administrators);
        log.info(administrators.toString());
        administrators.setAdminPassword(md5psw);
        administratorsService.save(administrators);
        return ResponseEntity.ok(adminDto.getAdminAccount());
    }

}



