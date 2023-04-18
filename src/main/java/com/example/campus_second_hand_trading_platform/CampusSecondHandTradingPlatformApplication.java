package com.example.campus_second_hand_trading_platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.example.campus_second_hand_trading_platform.dao.mapper")

public class CampusSecondHandTradingPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusSecondHandTradingPlatformApplication.class, args);//主程序
    }


}
