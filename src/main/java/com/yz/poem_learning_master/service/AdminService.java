package com.yz.poem_learning_master.service;

import com.yz.poem_learning_master.controller.DTO.AdminDTO;
import com.yz.poem_learning_master.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 12496
* @description 针对表【admin(管理员表
)】的数据库操作Service
* @createDate 2023-05-08 13:43:32
*/
public interface AdminService extends IService<Admin> {

    AdminDTO adminLogin(AdminDTO admin);

    List<Admin> getAllAdmin();
}
