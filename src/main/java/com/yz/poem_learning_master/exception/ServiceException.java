package com.yz.poem_learning_master.exception;

import lombok.Getter;

/**
 * Date: 2023/5/6 19:12
 * Author: hez
 * Description:
 */
@Getter
public class ServiceException extends RuntimeException{
    private String code;

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }
}
