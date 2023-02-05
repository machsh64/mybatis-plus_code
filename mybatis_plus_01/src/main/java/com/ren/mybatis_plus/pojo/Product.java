package com.ren.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: mybatis_plus
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-06 03:10
 * @description:
 **/
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private Long id;

    private String name;

    private Integer price;

    @Version  // 用来标识乐观锁版本号字段
    private Integer version;
}
