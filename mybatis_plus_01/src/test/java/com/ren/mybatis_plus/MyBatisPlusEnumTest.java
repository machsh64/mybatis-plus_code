package com.ren.mybatis_plus;

import com.ren.mybatis_plus.enums.SexEnum;
import com.ren.mybatis_plus.mapper.UserMapper;
import com.ren.mybatis_plus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: mybatis_plus
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-06 03:45
 * @description:
 **/
@Slf4j
@SpringBootTest
public class MyBatisPlusEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {

        User user = new User();
        user.setName("telunsu");
        user.setAge(22);
        user.setSex(SexEnum.MALE);
        int i = userMapper.insert(user);
        log.info("#### result : {}  #####",i);
    }
}
