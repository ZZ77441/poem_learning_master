package com.yz.poem_learning_master.config.interceptor;

import cn.hutool.jwt.JWTException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yz.poem_learning_master.common.Constants;
import com.yz.poem_learning_master.entity.User;
import com.yz.poem_learning_master.exception.ServiceException;
import com.yz.poem_learning_master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date: 2023/5/7 17:17
 * Author: hez
 * Description: 设置jwt拦截器
 */

@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //执行验证
        if (StringUtils.isBlank(token)) {
            throw new ServiceException(Constants.CODE_401, "无token请重新登录！");
        }
        //获取token中的userid
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        }catch (JWTException j) {
            throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录！");
        }
        User user = userService.getById(userId);
        if(user==null) {
            throw new ServiceException(Constants.CODE_401,"用户不存在，请重新登录");
        }

        //用户密码加签验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录！");
        }
        return true;

    }
}
