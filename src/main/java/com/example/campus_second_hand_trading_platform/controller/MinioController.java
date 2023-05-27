package com.example.campus_second_hand_trading_platform.controller;

import com.example.campus_second_hand_trading_platform.service.MinioService;
import com.example.campus_second_hand_trading_platform.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author cc
 */
@RestController
@Api
@RequestMapping("/minio")
@Slf4j
public class MinioController {
    @Autowired
    MinioService minioService;
    @PostMapping("/upload")
    @ApiOperation(value = "file")
    public CommonResult<?> upLoad(HttpServletRequest request, @RequestParam("file")MultipartFile file){
        try{
            minioService.upload(file);
            return CommonResult.success(1);
        }
        catch (Exception e){
            return CommonResult.failed("1");
        }

    }
}
