package com.yz.poem_learning_master.mapper;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yz.poem_learning_master.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 12496
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2023-04-23 17:07:16
* @Entity com.yz.poem_learning_master.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




