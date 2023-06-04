package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.mapper.UserMapper;
import com.example.campus_second_hand_trading_platform.domain.dto.UserDto;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.domain.vo.ChangeUserMsgVo;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import com.example.campus_second_hand_trading_platform.service.MinioService;
import com.example.campus_second_hand_trading_platform.utils.BeanUtils;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private IUserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    MinioService minioService;
    @PostMapping
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto){
        System.out.println(userDto.getUserName());
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public List<UserDto>getUsers(){
        List<User> users = userService.list();
        List<UserDto> userDtos = BeanUtils.copyPropertiesList(users, UserDto.class);
        return userDtos;
    }

    @GetMapping("/select")
    public UserDto getuser(@RequestParam int id){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userService.getById(id),userDto);
        return userDto;
    }
    @GetMapping("/getbyname")
    public List<UserDto> getuserbyname(@RequestParam String name){
        List<User> users = userService.getByName(name);
        List<UserDto> userDtos = BeanUtils.copyPropertiesList(users,UserDto.class);;
        return userDtos;
    }

    /**
     * 修改用户个人信息中通过用户id获取用户当前个人信息的接口
     * @param user_id
     * @return 用户信息
     */
    @GetMapping("GetAllUserMsg")
    public CommonResult GetAllUserMsg(@RequestParam int user_id){
        User user = userService.getById(user_id);
        ChangeUserMsgVo res = new ChangeUserMsgVo();
        BeanUtils.copyProperties(user,res);
        return CommonResult.success(res);
    }

    /**
     * 修改用户个人信息中修改个人信息的方法
     * @param changeUserMsgVo
     * @return 200
     */
    @PostMapping("ChangeUserMsg")
    public CommonResult ChangeUserMsg(@RequestBody ChangeUserMsgVo changeUserMsgVo){
        User user = new User();
        BeanUtils.copyProperties(changeUserMsgVo,user);
        return CommonResult.success(userService.updateById(user));
    }

    /**
     * 上传用户头像接口
     * @param file
     * @return 图片相对地址
     */
    @PostMapping("uploadImg")
    public CommonResult upload( @RequestParam MultipartFile file){
        return CommonResult.success(minioService.upload(file,"user",0));
    }
}
