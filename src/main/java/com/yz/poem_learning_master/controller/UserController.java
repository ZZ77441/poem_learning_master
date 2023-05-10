package com.yz.poem_learning_master.controller;


/**
 * Date: 2023/4/25 18:33
 * Author: hez
 * Description:
 */

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yz.poem_learning_master.common.Constants;
import com.yz.poem_learning_master.common.Result;
import com.yz.poem_learning_master.controller.DTO.UserDTO;
import com.yz.poem_learning_master.entity.User;
import com.yz.poem_learning_master.mapper.UserMapper;
import com.yz.poem_learning_master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //用户登录接口
    @PostMapping("/login")
    public Result userLogin(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return Result.error(Constants.CODE_400, "参数错误");
        }

        UserDTO dto = userService.userLogin(userDTO);
        return Result.success(dto);

    }

    //用户注册接口
    @PostMapping("/register")
    public Result userRegister(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        //判断用户传参是否为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return Result.error(Constants.CODE_400, "参数错误");
        }
        return Result.success(userService.userRegister(userDTO));
    }
}
