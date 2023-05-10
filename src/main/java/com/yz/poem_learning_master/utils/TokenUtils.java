package com.yz.poem_learning_master.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;


/**
 * Date: 2023/5/7 16:51
 * Author: hez
 * Description:
 */
public class TokenUtils {
    //生成token
    public static String genToken(String userId,String sign) {
        return  JWT.create()
                //签收者,将userId保存到token作为载荷
                .withAudience(userId)
                //主题
                .withSubject("token")
                //2小时候token过期
                .withExpiresAt(DateUtil.offsetHour(new Date(),2))
                //以password作为token的密钥
                .sign(Algorithm.HMAC256(sign));
    }
}
