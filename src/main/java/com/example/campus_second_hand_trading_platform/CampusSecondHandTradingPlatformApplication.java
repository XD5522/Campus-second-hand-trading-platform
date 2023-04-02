package com.example.campus_second_hand_trading_platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class CampusSecondHandTradingPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusSecondHandTradingPlatformApplication.class, args);//主程序
    }


}
