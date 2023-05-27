package com.example.campus_second_hand_trading_platform.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author cc
 */
public interface MinioService {
    public void upload(MultipartFile file);
    public void delete(String imgName);
}
