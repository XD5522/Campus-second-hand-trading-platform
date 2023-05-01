package com.example.campus_second_hand_trading_platform.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class ImageController {
    @Value("${image.home}")
    private String homeDir;

    @Value("${image.storage.path}")
    private String imageStoragePath;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        // 检查上传的文件是否为空
        if (file.isEmpty()) {
            return "上传的文件为空";
        }

        // 生成保存的文件名
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + extension;

        // 拼接文件的绝对路径
        String absolutePath = homeDir + imageStoragePath + "/" + fileName;

        // 保存文件到本地

        // 返回上传成功的信息
        return "上传成功，文件名为：" + fileName;
    }
}
