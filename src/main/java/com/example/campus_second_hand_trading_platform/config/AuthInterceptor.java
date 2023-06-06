package com.example.campus_second_hand_trading_platform.config;

import com.example.campus_second_hand_trading_platform.dao.entity.UserAccount;
import com.example.campus_second_hand_trading_platform.service.IUserAccountService;
import com.example.campus_second_hand_trading_platform.service.IUserLoginService;
import com.example.campus_second_hand_trading_platform.utils.JwtUtils;
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

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private IUserAccountService iUserAccountService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查用户的身份认证信息
        log.info(request.toString());
        String token = request.getHeader("token");
        String uri = request.getRequestURI();
        log.info(token);
        log.info(uri);
        if (uri.equals("/user/login") || uri.equals("/error") || uri.equals("/admin/login") || uri.equals("/user/register") || uri.equals("/admin/getUserData") || uri.equals("/admin/passUser")){
            //boolean test = jwtUtils.verifyToken(token, jwtUtils.getUserAccountByToken(token));
            return true;
        }
        else {
            String method;
            method = request.getMethod();
            if ("OPTIONS".equals(method)) {
                return true;
            }
            else if(token != null) {
                String userAccount = jwtUtils.getUserAccountByToken(token);
                UserAccount data = iUserAccountService.getByUserAccount(userAccount);
                log.info(userAccount);
                log.info(data.toString());
                return jwtUtils.verifyToken(token, data.getUserAccount().toString());
            }
        }
        log.info("false");
        // 用户的认证信息有效，放行请求
        return false;
    }

    // 其他方法
}