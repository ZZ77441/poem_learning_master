package com.yz.poem_learning_master.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.poem_learning_master.controller.DTO.UserDTO;
import com.yz.poem_learning_master.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 12496
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2023-04-23 17:07:16
*/
public interface UserService extends IService<User> {
    //新增和修改用户
    int saveUser(User user);

    //查询所有用户
    List<User> getAllUser();

    //根据用户id删除用户
    Integer deleteUserById(Integer id);

    //用户登录验证
    UserDTO userLogin(UserDTO userDTO);

    //用户注册
    User userRegister(UserDTO userDTO);

    //分页查询用户
    Page<User> getAllUserByPage(int pageSize, int current, QueryWrapper queryWrapper);
}
