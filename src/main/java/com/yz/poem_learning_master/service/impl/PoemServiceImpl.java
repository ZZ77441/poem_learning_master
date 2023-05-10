package com.yz.poem_learning_master.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yz.poem_learning_master.entity.Poem;
import com.yz.poem_learning_master.mapper.UserMapper;
import com.yz.poem_learning_master.service.PoemService;
import com.yz.poem_learning_master.mapper.PoemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 12496
* @description 针对表【poem(诗词表)】的数据库操作Service实现
* @createDate 2023-05-04 16:30:42
*/
@Service
public class PoemServiceImpl extends ServiceImpl<PoemMapper, Poem>
    implements PoemService{

    @Autowired
    private PoemMapper poemMapper;

    @Override
    public List<Poem> getAllPoem() {
        return poemMapper.selectList(null);
    }
}




