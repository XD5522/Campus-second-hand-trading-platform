package com.example.campus_second_hand_trading_platform.utils;

import com.example.campus_second_hand_trading_platform.dao.entity.Administrators;
import com.example.campus_second_hand_trading_platform.dao.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
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


    public String saveToken(User user,String userAccount,long expirationTimeMillis) {
        //过期时间
        String userId = user.getId().toString();
        log.info(userId);
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
        redisTemplate.opsForHash().put(token, "token",token);
        redisTemplate.opsForHash().put(token,"info",user);
        redisTemplate.expire(token, expirationMs, TimeUnit.MILLISECONDS);
        log.info(token);
        return token;
    }

    /**
     * 生成管理员的token
     * @param administrators
     * @param adminAccount
     * @param expirationTimeMillis
     * @return
     */

    public String adminToken(Administrators administrators, String adminAccount, long expirationTimeMillis) {
        //过期时间
        String adminId = administrators.getId().toString();
        log.info(adminId);
        long expirationMs = expirationTimeMillis*1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationMs);
        // 使用私钥签名 JWT Token
        String secretKey = KEY; // 私钥，需要保密
        String token = Jwts.builder()
                .setSubject(adminAccount)
                .setIssuer(ISS)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        // 将 JWT 存入 Redis，设置过期时间
        redisTemplate.opsForSet().add(adminId,token);
        redisTemplate.expire(adminId, expirationMs, TimeUnit.MILLISECONDS);
        redisTemplate.opsForHash().put(token, "token",token);
        redisTemplate.opsForHash().put(token,"info",administrators);
        redisTemplate.expire(token, expirationMs, TimeUnit.MILLISECONDS);
        log.info(token);
        return token;
    }

    /**
     * 从token中获取登录用户名
     * @param token 客户端传入的token
     * @return
     */
    public String getUserAccountByToken(String token) {
        String userAccount;
        String secretKey = KEY; // 私钥，需要保密
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        userAccount = claims.getSubject();
        return userAccount;
    }

    /**
     * 从token中获取管理员账户
     * @param token 客户端传入的token
     * @return
     */
    public String getAdminAccountByToken(String token) {
        String adminAccount;
        String secretKey = KEY; // 私钥，需要保密
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        adminAccount = claims.getSubject();
        return adminAccount;
    }

    /**
     * 判断token是否过期
     * @param token 客户端传入的token
     * @return
     */
    public boolean isTokenExpired(String token) {
        String secretKey = KEY;
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        Date expirationDate = claims.getExpiration();
        return expirationDate.before(new Date());
    }

    /**
     * 验证token是否有效
     * @param token 客户端传入的token
     * @param data 数据库中找到的数据
     * @return
     */
    public boolean verifyToken(String token, String data) {
        String userAccount = getUserAccountByToken(token);
        return userAccount.equals(data) && !isTokenExpired(token);
    }

    /**
     * 验证管理员token是否有效
     * @param token 客户端传入的token
     * @param data 数据库中找到的数据
     * @return
     */
    public boolean verifyAdminToken(String token, String data) {
        String adminAccount = getAdminAccountByToken(token);
        return adminAccount.equals(data) && !isTokenExpired(token);
    }

    public boolean isTokenExists(HttpServletRequest request) {
        // 判断 JWT 是否存在于 Redis 中
        String jwtToken = request.getHeader("token");

        return redisTemplate.hasKey(jwtToken);
    }

    public void deleteToken(String jwtToken) {
        // 从 Redis 中删除 JWT
        redisTemplate.delete(jwtToken);
    }

//    private String generateToken(Map<String, Object> claims) {
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(generateExpirationDate())
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//    public String generateToken(User userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
//        claims.put(CLAIM_KEY_CREATED, new Date());
//        return generateToken(claims);
//    }

}
