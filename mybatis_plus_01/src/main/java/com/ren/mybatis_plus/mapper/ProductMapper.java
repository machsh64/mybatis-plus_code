package com.ren.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ren.mybatis_plus.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: mybatis_plus
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-06 03:11
 * @description:
 **/
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
