package com.example.campus_second_hand_trading_platform.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import com.example.campus_second_hand_trading_platform.domain.dto.UserDto;
import com.example.campus_second_hand_trading_platform.domain.vo.ProductVo;
import com.example.campus_second_hand_trading_platform.domain.vo.UserVo;
import com.example.campus_second_hand_trading_platform.service.IProductService;
import com.example.campus_second_hand_trading_platform.service.IUserAccountService;
import com.example.campus_second_hand_trading_platform.service.IUserService;
import com.example.campus_second_hand_trading_platform.service.MinioService;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * TODO
 *
 * @Description 管理员控制器
 * @Author qionghua
 * @Date 2023/6/6 20:18
 **/
@Slf4j
@RequestMapping("/admin")
@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    private IUserService iUserService;

    @Autowired
    private IUserAccountService iUserAccountService;

    @Autowired
    private IProductService iProductService;

    @Autowired
    private MinioService minioService;

    /**
     * 获取通过审核的用户
     * @return
     */

    @GetMapping("/getUserData")
    public CommonResult<List<UserVo>> getAllUser() {
        List<UserVo> data;
        data = iUserService.getAllUser();
        return CommonResult.success(data);
    }

    /**
     * 获取还未审核和未通过审核的用户
     * @return
     */

    @GetMapping("/getAuditUserData")
    public CommonResult<List<UserVo>> getAuditUser() {
        List<UserVo> data;
        data = iUserService.getAuditUser();
        return CommonResult.success(data);
    }

    /**
     * 获取还未审核和未通过审核的商家
     * @return
     */

    @GetMapping("/getAuditMerchantData")
    public CommonResult<List<UserVo>> getAuditMerchant() {
        List<UserVo> data;
        data = iUserService.getAuditMerchant();
        return CommonResult.success(data);
    }

    /**
     * 用户通过审核
     * @param userName
     * @return
     */
    @PostMapping("/passUser")
    public CommonResult<?> passUser(@RequestParam String userName) {

        log.info(userName.toString());

        if(iUserService.passUser(userName)) {
            log.info("审核通过");
            return CommonResult.success("审核通过");
        }
        return CommonResult.failed();
    }

    /**
     * 用户不通过审核
     * @param userName
     * @return
     */
    @PostMapping("/noPassUser")
    public CommonResult<?> noPassUser(@RequestParam String userName) {

        log.info(userName.toString());

        if(iUserService.noPassUser(userName)) {
            log.info("审核未通过");
            return CommonResult.success("审核未通过");
        }
        return CommonResult.failed();
    }

    @PostMapping("/banUser")
    public CommonResult<?> banUser(@RequestParam String userName) {

        log.info(userName.toString());

        if(iUserService.banUser(userName)) {
            log.info("封禁成功");
            return CommonResult.success("封禁成功");
        }
        return CommonResult.failed();
    }

    @PostMapping("/deleteUser")
    public CommonResult<?> deleteUser(@RequestParam String userName) {

        log.info(userName.toString());

        User user;
        user = iUserService.getByUserName(userName);

        if(iUserService.deleteUser(userName) && iUserAccountService.deleteUserAccount(user.getId())) {
            log.info("删除成功");
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed();
    }

    @GetMapping("/searchUser")
    public CommonResult<List<UserVo>> searchUser(@RequestParam String searchText, @RequestParam int page, @RequestParam int pageSize) {
        int start = (page - 1) * pageSize;
        log.info(String.valueOf(start));
        List<UserVo> data;
        data = iUserService.searchUser(searchText, start, pageSize);
        return CommonResult.success(data);
    }

    @GetMapping("/searchAuditUser")
    public CommonResult<List<UserVo>> searchAuditUser(@RequestParam String searchText, @RequestParam int page, @RequestParam int pageSize) {
        int start = (page - 1) * pageSize;
        log.info(String.valueOf(start));
        List<UserVo> data;
        data = iUserService.searchAuditUser(searchText, start, pageSize);
        return CommonResult.success(data);
    }

    @GetMapping("/searchProduct")
    public CommonResult<?> searchProductByName(HttpServletRequest request, @RequestParam String name, @RequestParam int current, @RequestParam int num, @RequestParam String order, @RequestParam String asc){
        IPage<ProductVo> products = iProductService.SearchProducts(name, order, asc, current, num);
        log.info(order);
        return CommonResult.success(products);
    }

    @GetMapping("/searchAuditProduct")
    public CommonResult<?> searchAuditProductByName(HttpServletRequest request, @RequestParam String name, @RequestParam int current, @RequestParam int num, @RequestParam String order, @RequestParam String asc){
        IPage<ProductVo> products = iProductService.SearchAuditProducts(name, order, asc, current, num);
        log.info(order);
        return CommonResult.success(products);
    }

    @PostMapping("/releaseProduct")
    public CommonResult<?> releaseProduct(@RequestParam int productId, @RequestParam String state) {
        if(iProductService.ChangeProductState(productId, state) == 1) {
            log.info("发布成功");
            return CommonResult.success("发布成功");
        }
        return CommonResult.failed();
    }

    @PostMapping("/downProduct")
    public CommonResult<?> downProduct(@RequestParam int productId, @RequestParam String state) {
        if(iProductService.ChangeProductState(productId, state) == 1) {
            log.info("下架成功");
            return CommonResult.success("下架成功");
        }
        return CommonResult.failed();
    }

    @PostMapping("/deleteProduct")
    public CommonResult<?> deleteProduct(@RequestParam int productId) {
        if(iProductService.deleteProduct(productId) == 1) {
            log.info("删除成功");
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed();
    }

    @PostMapping("/edit")
    public CommonResult<?> edit(@RequestParam int id, @RequestParam String userName, @RequestParam String name, @RequestParam String city, @RequestParam String type) {
        if(iUserService.editMessage(id, userName, name, city, type)) {
            log.info("修改成功");
            return CommonResult.success("修改成功");
        }
        return CommonResult.failed();
    }

    @PostMapping("/reset")
    public CommonResult<?> reset(@RequestParam String userName) {

        User user = iUserService.getByUserName(userName);
        if(iUserService.resetPassword(user.getId())) {
            log.info("重置成功");
            return CommonResult.success("重置成功");
        }
        return CommonResult.failed();
    }
}
