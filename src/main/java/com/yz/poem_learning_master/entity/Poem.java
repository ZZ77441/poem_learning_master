package com.yz.poem_learning_master.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 诗词表
 * @TableName poem
 */
@TableName(value ="poem")
@Data
public class Poem implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long poemId;

    /**
     * 诗文标题
     */
    private String poemTitle;

    /**
     * 作者
     */
    private String poemAuthor;

    /**
     * 朝代
     */
    private String poemDynasty;

    /**
     * 内容 json
     */
    private Object poemContent;

    /**
     * 诗文注释
     */
    private String poemComment;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}