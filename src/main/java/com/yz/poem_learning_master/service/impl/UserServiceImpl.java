package com.yz.poem_learning_master.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yz.poem_learning_master.common.Constants;
import com.yz.poem_learning_master.controller.DTO.UserDTO;
import com.yz.poem_learning_master.entity.User;
import com.yz.poem_learning_master.exception.ServiceException;
import com.yz.poem_learning_master.service.UserService;
import com.yz.poem_learning_master.mapper.UserMapper;
import com.yz.poem_learning_master.utils.SHAUtils;
import com.yz.poem_learning_master.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author 12496
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2023-04-23 17:07:16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    private UserMapper userMapper;

    public int saveUser(User user) {
        //user没有id时是新增
        if (user.getUserId() == null) {
            return userMapper.insert(user);
        } else {
            //否则为更新用户
            return userMapper.updateById(user);
        }

    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectList(null);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public UserDTO userLogin(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        //判断是否查询到用户
        if (one != null) {
            BeanUtils.copyProperties(one, userDTO);
            //设置token
            String token = TokenUtils.genToken(one.getUserId().toString(), one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        } else {
            throw new ServiceException(Constants.CODE_403, "用户名或密码错误！");
        }
    }

    @Override
    public User userRegister(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if(one == null) {
            one = new User();
            BeanUtils.copyProperties(userDTO, one);
            //默认将用户名设置为用户昵称
            one.setNickname(one.getUsername());
            one.setPassword(SHAUtils.encrypt(userDTO.getPassword()));
            saveUser(one);
        } else  {
            throw new ServiceException(Constants.CODE_403, "用户已存在！");
        }
        return one;
    }

    @Override
    public Page<User> getAllUserByPage(int pageSize, int current, QueryWrapper wrapper) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:MM:ss");
        Page<User> page = new Page<>(current, pageSize);
        return userMapper.selectPage(page, wrapper);
    }

    //查询用户信息
    private User getUserInfo(UserDTO userDTO) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", userDTO.getUsername());
        userQueryWrapper.eq("password", SHAUtils.encrypt(userDTO.getPassword()));
        User one;
        //getOne可能查询多个结果导致出错
        try {
            one = getOne(userQueryWrapper);
        } catch (Exception e) {
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        return one;
    }
}




