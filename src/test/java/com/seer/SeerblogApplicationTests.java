package com.seer;

import com.seer.entity.User;
import com.seer.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SeerblogApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        User seer = userService.checkUser("seer");
        System.out.println(seer);
    }

}
