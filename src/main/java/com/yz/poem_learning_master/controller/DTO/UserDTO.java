package com.yz.poem_learning_master.controller.DTO;

import lombok.Data;


/**
 * Date: 2023/4/27 17:10
 * Author: hez
 * Description: 接受前端登录请求数据
 */
@Data
public class UserDTO {
    private Long userId;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String createDate;
    private String token;
}
