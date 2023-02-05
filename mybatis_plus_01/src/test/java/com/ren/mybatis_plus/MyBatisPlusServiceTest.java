package com.ren.mybatis_plus;

import com.ren.mybatis_plus.pojo.User;
import com.ren.mybatis_plus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

/**
 * @program: mybatis_plus
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-05 02:19
 * @description:
 **/
@Slf4j
@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount() {

        // 查询总记录数
        // SELECT COUNT( * ) FROM user
        long count = userService.count();
        log.info("##### count : {}  ######",count);
    }

    @Test
    public void testInserMore() {

        // 批量添加
        //  INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        LinkedList<User> userList = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            User user = new User();
            user.setName("merge_"+i);
            user.setAge(20+i);
            user.setEmail("emojo_"+i+"@gmail.com");
            userList.add(user);
        }
        boolean b = userService.saveBatch(userList);
        log.info("##### Boolean : {} #####",b);
    }
}
