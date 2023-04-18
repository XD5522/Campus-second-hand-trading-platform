package com.example.campus_second_hand_trading_platform.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JWT {

    @Autowired
    private static RedisTemplate<String, String> redisTemplate;

    public static void saveToken(String userId,long expirationTimeMillis) {

        long expirationMs = 3600000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationMs);

        // 使用私钥签名 JWT Token
        String secretKey = "yourSecretKey"; // 私钥，需要保密
        String token = Jwts.builder()
                .setSubject(userId)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();


        // 将 JWT 存入 Redis，设置过期时间
        redisTemplate.opsForValue().set(token, token);
        redisTemplate.expire(token, expirationTimeMillis, TimeUnit.MILLISECONDS);
    }

    public static boolean isTokenExists(String jwtToken) {
        // 判断 JWT 是否存在于 Redis 中
        return redisTemplate.hasKey(jwtToken);
    }

    public static void deleteToken(String jwtToken) {
        // 从 Redis 中删除 JWT
        redisTemplate.delete(jwtToken);
    }
}
