package com.example.campus_second_hand_trading_platform.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.dialect.pagination.LimitOffsetLimitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查用户的身份认证信息
        String token = request.getHeader("token");
        String uri = request.getRequestURI();
        log.info(uri);
        if (uri.equals("/api/login") || uri.equals("/error") || uri.equals("/admin/login")){
            return true;
        }

        String tk = redisTemplate.opsForValue().get(token).toString();
        log.info(tk);
        if (tk == null) {
            // 如果用户的认证信息无效，可以直接返回错误信息或者跳转到登录页面
            return false;
        }
        // 用户的认证信息有效，放行请求
        return true;
    }

    // 其他方法
}