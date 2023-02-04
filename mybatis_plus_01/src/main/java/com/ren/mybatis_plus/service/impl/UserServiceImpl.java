package com.ren.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ren.mybatis_plus.mapper.UserMapper;
import com.ren.mybatis_plus.pojo.User;
import com.ren.mybatis_plus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @program: mybatis_plus
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-05 02:17
 * @description:
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
