package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.Administrators;
import com.example.campus_second_hand_trading_platform.domain.dto.AdminDto;
import com.example.campus_second_hand_trading_platform.domain.vo.AdminVo;
import com.example.campus_second_hand_trading_platform.service.IAdministratorsService;
import com.example.campus_second_hand_trading_platform.utils.BeanUtils;
import com.example.campus_second_hand_trading_platform.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Description:用户登录控制器
* date: 2023/4/22 15:53
* @author cc
* @since JDK17
*/
@RestController
@RequestMapping("/api/admin")
@CrossOrigin
@Slf4j
public class AdminLoginController {


    @Autowired
    IAdministratorsService administratorsService;
    @Autowired
    JwtUtils jwtUtils;

    /**
     * 登录接口
     * @param request
     * @param adminDto
     * @return
     *
     */
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
    public List<AdminVo> test(HttpServletRequest request){
        List<Administrators> administrators = administratorsService.list();
        List<AdminVo> adminVos = BeanUtils.copyPropertiesList(administrators,AdminVo.class);
        log.info(administrators.toString());
        log.info(adminVos.toString());
        return adminVos;
    }

}



