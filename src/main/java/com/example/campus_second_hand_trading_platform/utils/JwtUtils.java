package com.example.campus_second_hand_trading_platform.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
* Description:
* date: 2023/4/22 15:38
* @author cc
* @since JDK17
*/

@Component
@Slf4j
public class JwtUtils {


    private static final String KEY = "1GH4234ig12G3UYG45U4GV8JGH48F76D4TF69Y97REYG793Q4TG9R2";
    private static final String ISS = "c225cc";
    @Autowired
    private RedisTemplate redisTemplate;

    public String saveToken(String userId,String userAccount,long expirationTimeMillis) {
        //过期时间
        long expirationMs = expirationTimeMillis*1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationMs);
        // 使用私钥签名 JWT Token
        String secretKey = KEY; // 私钥，需要保密
        String token = Jwts.builder()
                .setSubject(userAccount)
                .setIssuer(ISS)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        // 将 JWT 存入 Redis，设置过期时间
        redisTemplate.opsForSet().add(userId,token);
        redisTemplate.expire(userId, expirationMs, TimeUnit.MILLISECONDS);
        redisTemplate.opsForValue().set(token, token);
        redisTemplate.expire(token, expirationMs, TimeUnit.MILLISECONDS);
        log.info(token);
        return token;
    }

    public boolean isTokenExists(HttpServletRequest request) {
        // 判断 JWT 是否存在于 Redis 中
        String jwtToken = request.getHeader("***");

        return redisTemplate.hasKey(jwtToken);
    }

    public void deleteToken(String jwtToken) {
        // 从 Redis 中删除 JWT
        redisTemplate.delete(jwtToken);
    }
}
