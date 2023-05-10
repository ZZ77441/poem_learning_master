package com.yz.poem_learning_master;

import com.yz.poem_learning_master.entity.User;
import com.yz.poem_learning_master.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Date: 2023/4/25 21:33
 * Author: hez
 * Description:
 */
@SpringBootTest
public class MybatisPlusCrudTest {
    @Autowired
    UserService userService;

    @Test
    public void updateUser() {
        User user = new User();
        user.setUserId(8L);
        user.setEmail("9999@qq.com");
        boolean result = userService.updateById(user);
        System.out.println(result);
    }
}
