package com.yz.poem_learning_master.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date: 2023/5/6 18:13
 * Author: hez
 * Description:接口统一返回的包装类
 */
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String code;
    private String msg;
    private Object data;

    //无信息的返回成功
    public static Result success() {
        return new Result(Constants.CODE_200,"",null);
    }

    //有信息的返回成功
    public static Result success(Object data) {
        return new Result(Constants.CODE_200,"",data);
    }

    //错误
    public static Result error(String code,String msg) {
        return new Result(code,msg,null);
    }

    public static Result error() {
        return new Result(Constants.CODE_500,"系统错误",null);
    }
}
