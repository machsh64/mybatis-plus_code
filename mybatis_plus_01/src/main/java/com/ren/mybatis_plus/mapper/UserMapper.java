package com.ren.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ren.mybatis_plus.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @program: mybatis_plus
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-05 00:55
 * @description:
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> selectMapById(@Param("id") Long id);
}
