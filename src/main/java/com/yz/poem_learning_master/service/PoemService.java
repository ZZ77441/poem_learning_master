package com.yz.poem_learning_master.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.poem_learning_master.entity.Poem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 12496
* @description 针对表【poem(诗词表)】的数据库操作Service
* @createDate 2023-05-04 16:30:42
*/
public interface PoemService extends IService<Poem> {

    List<Poem> getAllPoem();

    List<Poem> getRandomPoem();

    Page<Poem> getAllPoemByPage(int pageSize, int current, QueryWrapper queryWrapper);

    int deletePoemById(Integer id);
}
