package com.yz.poem_learning_master.mapper;

import com.yz.poem_learning_master.entity.Poem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 12496
* @description 针对表【poem(诗词表)】的数据库操作Mapper
* @createDate 2023-05-04 16:30:42
* @Entity com.yz.poem_learning_master.entity.Poem
*/
@Mapper
public interface PoemMapper extends BaseMapper<Poem> {
    List<Poem> getRandomPoem();
}




