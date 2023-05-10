package com.yz.poem_learning_master.mapper;

import com.yz.poem_learning_master.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 12496
* @description 针对表【admin(管理员表
)】的数据库操作Mapper
* @createDate 2023-05-08 13:43:32
* @Entity com.yz.poem_learning_master.entity.Admin
*/
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}




