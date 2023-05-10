package com.yz.poem_learning_master.controller;

import com.yz.poem_learning_master.entity.Poem;
import com.yz.poem_learning_master.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    //查询所有古诗
    @GetMapping
    public List<Poem> getAllPoem() {
         return poemService.getAllPoem() ;
    }
}
