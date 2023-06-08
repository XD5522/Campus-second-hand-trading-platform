package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import com.example.campus_second_hand_trading_platform.service.WalletService;
import com.example.campus_second_hand_trading_platform.utils.BeanUtils;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author cc
 */

@RestController
@Slf4j
@RequestMapping("wallet")
@CrossOrigin
public class WalletController {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    IUserService userService;
    @Autowired
    WalletService walletService;

    @GetMapping("user")
    public CommonResult<?> getUser(HttpServletRequest request){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"info");
        try{
            BeanUtils.copyProperties(object,user);
            int id = user.getId();
            User user1= userService.getById(id);
            return CommonResult.success(user1);
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping("recharge")
    public CommonResult<?> reCharge(HttpServletRequest request, @RequestParam int num){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"info");
        try{
            BeanUtils.copyProperties(object,user);
            int id = user.getId();
            log.info(String.valueOf(num));
            walletService.reCharge(id,num);
            return CommonResult.success(num);
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping("getMoney")
    public CommonResult<?> getMoney(HttpServletRequest request, @RequestParam int num){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"info");
        try{
            BeanUtils.copyProperties(object,user);
            int id = user.getId();
            walletService.getMoney(id,num);
            return CommonResult.success(num);
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping("/record/recharge")
    public CommonResult<?> getRecharge(HttpServletRequest request){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"info");
        try{
            BeanUtils.copyProperties(object,user);
            int id = user.getId();
            return CommonResult.success(walletService.getRecharge(id));
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping("/record/getMoney")
    public CommonResult<?> getMoneyRecord(HttpServletRequest request){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"info");
        try{
            BeanUtils.copyProperties(object,user);
            int id = user.getId();
            return CommonResult.success(walletService.getMoney(id));
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping("/record/income")
    public CommonResult<?> getIncome(HttpServletRequest request){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"info");
        try{
            BeanUtils.copyProperties(object,user);
            int id = user.getId();

            return CommonResult.success(walletService.getIncome(id));
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping("/record/payout")
    public CommonResult<?> getPayout(HttpServletRequest request){
        String token = request.getHeader("token");
        User user = new User();
        Object object = redisTemplate.opsForHash().get(token,"info");
        try{
            BeanUtils.copyProperties(object,user);
            int id = user.getId();
            log.info(String.valueOf(id));
            log.info(String.valueOf(id));
            log.info(String.valueOf(id));
            log.info(String.valueOf(id));
            log.info(String.valueOf(id));
            log.info(walletService.getPayout(id).toString());
            return CommonResult.success(walletService.getPayout(id));
        }
        catch (Exception e){
            log.info(e.getMessage());
            return CommonResult.failed(e.getMessage());
        }
    }
}
