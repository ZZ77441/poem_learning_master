package com.yz.poem_learning_master.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.poem_learning_master.common.Constants;
import com.yz.poem_learning_master.common.Result;
import com.yz.poem_learning_master.controller.DTO.AdminDTO;
import com.yz.poem_learning_master.controller.DTO.UserDTO;
import com.yz.poem_learning_master.entity.Admin;
import com.yz.poem_learning_master.entity.User;
import com.yz.poem_learning_master.service.AdminService;
import com.yz.poem_learning_master.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Date: 2023/5/8 13:44
 * Author: hez
 * Description:
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    //管理员登录接口
    @PostMapping("/login")
    public Result adminLogin(@RequestBody AdminDTO admin) {
        String username = admin.getUsername();
        String password = admin.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return Result.error(Constants.CODE_400, "参数错误");
        }
        AdminDTO dto = adminService.adminLogin(admin);
        return Result.success(dto);
    }

    //查询所有用户
    @GetMapping("/getAllAdmin")
    public List<Admin> getAllAdmin() {
        List<Admin> allAdmin = adminService.getAllAdmin();
        return allAdmin;
    }

    //查询所有用户
    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return allUser;
    }

    //新增或者更新用户
    @PostMapping
    public Integer saveUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return userService.saveUser(user);
    }

    //按id删除用户
    @DeleteMapping("/{id}")
    public Integer deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserById(id);
    }

    //按页查询用户
    @GetMapping("/getAllUserByPage")
    public Page<User> getAllUserByPage(@RequestParam(defaultValue = "10") int pageSize,
                                       @RequestParam(defaultValue = "1") int current,
                                       @RequestParam(defaultValue = "") Integer userId,
                                       @RequestParam(defaultValue = "") String username,
                                       @RequestParam(defaultValue = "") String nickname,
                                       @RequestParam(defaultValue = "") String email,
                                       @RequestParam(defaultValue = "") String phone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (userId != null) {
            queryWrapper.like("user_id", userId);
        }
        if (!"".equals(username)) {
            queryWrapper.like("username", username);
        }
        if (!"".equals(nickname)) {
            queryWrapper.like("nickname", nickname);
        }
        if (!"".equals(email)) {
            queryWrapper.like("email", email);
        }
        if (!"".equals(phone)) {
            queryWrapper.like("phone", phone);
        }
        return userService.getAllUserByPage(pageSize, current, queryWrapper);
    }


}
