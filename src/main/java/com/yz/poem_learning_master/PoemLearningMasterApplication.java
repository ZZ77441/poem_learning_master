package com.yz.poem_learning_master;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
@MapperScan("com.yz.poem_learning_master.mapper")
public class PoemLearningMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoemLearningMasterApplication.class, args);
    }

}
