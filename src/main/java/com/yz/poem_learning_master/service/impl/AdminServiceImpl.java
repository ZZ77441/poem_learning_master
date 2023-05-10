package com.yz.poem_learning_master.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yz.poem_learning_master.common.Constants;
import com.yz.poem_learning_master.controller.DTO.AdminDTO;
import com.yz.poem_learning_master.entity.Admin;
import com.yz.poem_learning_master.exception.ServiceException;
import com.yz.poem_learning_master.service.AdminService;
import com.yz.poem_learning_master.mapper.AdminMapper;
import com.yz.poem_learning_master.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 12496
* @description 针对表【admin(管理员表
)】的数据库操作Service实现
* @createDate 2023-05-08 13:43:32
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

    @Autowired
    AdminMapper adminMapper;

    @Override
    public AdminDTO adminLogin(AdminDTO admin) {
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper.eq("username",admin.getUsername());
        adminQueryWrapper.eq("password",admin.getPassword());
        Admin one;
        try {
            one = getOne(adminQueryWrapper);
        }catch (Exception e ) {
            throw new ServiceException(Constants.CODE_500, "系统错误");
        }
        //判断是否查询到用户
        if (one != null) {
            //设置token
            String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
            AdminDTO adminDTO = new AdminDTO();
            BeanUtils.copyProperties(one, adminDTO);
            adminDTO.setToken(token);
            return adminDTO;
        } else {
            throw new ServiceException(Constants.CODE_403, "用户名或密码错误！");
        }
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminMapper.selectList(null);
    }
}




