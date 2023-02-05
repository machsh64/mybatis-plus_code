package com.ren.mybatis_plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ren.mybatis_plus.mapper.ProductMapper;
import com.ren.mybatis_plus.mapper.UserMapper;
import com.ren.mybatis_plus.pojo.Product;
import com.ren.mybatis_plus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: mybatis_plus
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-06 02:23
 * @description:
 **/
@Slf4j
@SpringBootTest
public class MyBatisPlusPluginsTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testPage() {

        Page<User> page = new Page<>(2,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        log.info("#####  userPage : {} #####",userPage);
        log.info("#####  userPage.getRedords : {} #####",userPage.getRecords());
        log.info("#####  userPage.getPages : {} #####",userPage.getPages());
        log.info("#####  userPage.getSize : {} #####",userPage.getSize());

    }

    @Test
    public void testPageVo() {
        Page<User> page = new Page<>(1,3);
        Page<User> userPage = userMapper.selectPageVo(page, 20);
        log.info("#####  userPage : {} #####",userPage);
        log.info("#####  userPage.getRedords : {} #####",userPage.getRecords());
        log.info("#####  userPage.getPages : {} #####",userPage.getPages());
        log.info("#####  userPage.getSize : {} #####",userPage.getSize());
    }

    @Test
    public void testProduct01() {

        // 小李查询商品价格
        Product productLI = productMapper.selectById(1);
        log.info("#### 小李查询的商品价格 {} ####",productLI.getPrice());

        // 小王查询商品价格
        Product productWANG = productMapper.selectById(1);
        log.info("#### 小王查询的商品价格 {} ####",productWANG.getPrice());

        // 小李将商品价格 + 50
        productLI.setPrice(productLI.getPrice() + 50);
        productMapper.updateById(productLI);

        // 小王将商品价格 - 30
        productWANG.setPrice(productWANG.getPrice() - 30);
        int i = productMapper.updateById(productWANG);
        if (i == 0){
            // 操作失败，重试
            productWANG = productMapper.selectById(1);
            productWANG.setPrice(productWANG.getPrice() - 30);
            productMapper.updateById(productWANG);
        }

        // 老板插叙你商品价格
        Product productBOSS = productMapper.selectById(1);
        log.info("#### Boss查询的商品价格 {} ####",productBOSS.getPrice());
    }
}
