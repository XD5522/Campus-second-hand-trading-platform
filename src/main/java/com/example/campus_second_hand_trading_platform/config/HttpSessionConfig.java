package com.example.campus_second_hand_trading_platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 20 * 60)
public class HttpSessionConfig {
    @Bean
    public static ConfigureRedisAction configureRedisAction(){
        return ConfigureRedisAction.NO_OP;
    }
}
