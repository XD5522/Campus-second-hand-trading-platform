package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dto.UserDto;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        System.out.println(userDto.getName());
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public List<User>getUsers(){
        List<User> users = userService.getBaseMapper().selectList(null);
        return users;
    }

    @GetMapping("/")
    public UserDto getuser(@RequestParam int id){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userService.getById(id),userDto);
        return userDto;
    }


}
