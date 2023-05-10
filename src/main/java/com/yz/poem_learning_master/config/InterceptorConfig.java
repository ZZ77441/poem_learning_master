package com.yz.poem_learning_master.config;

import com.yz.poem_learning_master.config.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Date: 2023/5/7 17:34
 * Author: hez
 * Description:
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor())
//                //拦截所有请求，判断token是否合法，决定是否登录
//                .addPathPatterns("/**")
//                .excludePathPatterns("**/login","**/register");
    }

    @Bean
    public JWTInterceptor jwtInterceptor() {
        return new JWTInterceptor();
    }
}
