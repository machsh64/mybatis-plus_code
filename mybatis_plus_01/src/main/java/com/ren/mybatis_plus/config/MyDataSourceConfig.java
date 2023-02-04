package com.ren.mybatis_plus.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @program: mybatis_plus
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-05 00:39
 * @description:
 **/
@Configuration(proxyBeanMethods = true)
public class MyDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource getDataSource(){

        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}
