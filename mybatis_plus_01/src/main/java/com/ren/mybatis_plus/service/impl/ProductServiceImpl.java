package com.ren.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ren.mybatis_plus.mapper.ProductMapper;
import com.ren.mybatis_plus.pojo.Product;
import com.ren.mybatis_plus.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @program: mybatis_plus
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-06 03:12
 * @description:
 **/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
