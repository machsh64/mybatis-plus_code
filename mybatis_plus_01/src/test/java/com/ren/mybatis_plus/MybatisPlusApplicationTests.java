package com.ren.mybatis_plus;

import com.ren.mybatis_plus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
      log.info("datasource: {}",dataSource.getClass());
    }

}
