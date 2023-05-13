package com.yz.poem_learning_master.controller.DTO;

import com.yz.poem_learning_master.entity.Poem;
import lombok.Data;

/**
 * Date: 2023/5/11 14:17
 * Author: hez
 * Description:
 */
@Data
public class PoemDTO extends Poem{
    private Integer current;
    private Integer pageSize;
    private String queryCondition;
}
