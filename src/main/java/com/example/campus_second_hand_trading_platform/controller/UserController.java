package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.controller.dto.UserDto;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import com.example.campus_second_hand_trading_platform.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cc
 * @since 2023-04-03
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(user,userDto);
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public List<User>getUsers(){
        List<User> users = userService.getBaseMapper().selectList(null);
        return users;
    }


}
