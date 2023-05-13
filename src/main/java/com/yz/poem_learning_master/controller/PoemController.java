package com.yz.poem_learning_master.controller;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.poem_learning_master.common.Result;
import com.yz.poem_learning_master.controller.DTO.PoemDTO;
import com.yz.poem_learning_master.entity.Poem;
import com.yz.poem_learning_master.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Date: 2023/5/4 16:33
 * Author: hez
 * Description:
 */
@RestController
@RequestMapping("/poem")
public class PoemController {
    @Autowired
    PoemService poemService;

    /**
     * 查询所有古诗
     *
     * @return
     */
    @GetMapping
    public List<Poem> getAllPoem() {
        return poemService.getAllPoem();
    }

    /**
     * 随机抽取20首古诗词作为推荐
     *
     * @return
     */
    @GetMapping("/recommend")
    public Result recommend() {
        List<Poem> randomPoem = poemService.getRandomPoem();
        return Result.success(randomPoem);
    }

    /**
     * 分页查询诗词
     * @param pageSize
     * @param current
     * @param poemId
     * @param poemTitle
     * @param poemAuthor
     * @param poemDynasty
     * @param poemContent
     * @param poemComment
     * @return
     */
    @GetMapping("/getAllPoemByPage")
    public Page<Poem> getAllPoemByPage(@RequestParam(defaultValue = "10") int pageSize,
                                   @RequestParam(defaultValue = "1") int current,
                                   @RequestParam(defaultValue = "") Integer poemId,
                                   @RequestParam(defaultValue = "") String poemTitle,
                                   @RequestParam(defaultValue = "") String poemAuthor,
                                   @RequestParam(defaultValue = "") String poemDynasty,
                                   @RequestParam(defaultValue = "") String poemContent,
                                   @RequestParam(defaultValue = "") String poemComment) {

        QueryWrapper<Poem> queryWrapper = new QueryWrapper<>();
        if(poemId!=null) {
            queryWrapper.like("poem_id",poemId);
        }
        if(!"".equals(poemTitle)) {
            queryWrapper.like("poem_title",poemTitle);
        }
        if(!"".equals(poemAuthor)) {
            queryWrapper.like("poem_author",poemAuthor);
        }
        if(!"".equals(poemDynasty)) {
            queryWrapper.like("poem_dynasty",poemDynasty);
        }
        if(!"".equals(poemContent)) {
            queryWrapper.like("poem_content",poemContent);
        }
        if(!"".equals(poemComment)) {
            queryWrapper.like("poem_comment",poemComment);
        }
        return poemService.getAllPoemByPage(pageSize,current,queryWrapper);
    }

    /**
     * 保存或修改古诗词
     * @param poem
     * @return
     */
    @PostMapping
    public Result savePoem(@RequestBody Poem poem) {
        boolean b = poemService.saveOrUpdate(poem);
        if(b) {
            return Result.success();
        }
        else  {
            return Result.error();
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Integer deletePoem(@PathVariable Integer id) {
        return poemService.deletePoemById(id);
    }
}
