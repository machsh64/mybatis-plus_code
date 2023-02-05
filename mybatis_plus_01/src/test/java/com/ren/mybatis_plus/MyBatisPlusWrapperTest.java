package com.ren.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ren.mybatis_plus.mapper.UserMapper;
import com.ren.mybatis_plus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @program: mybatis_plus
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-06 00:37
 * @description:
 **/
@Slf4j
@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {

        // 查询用户名包含a，年龄在20-30之间，邮箱信息不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> userList = userMapper.selectList(queryWrapper);
        log.info("######## UserList :  {} #######", userList);
    }

    @Test
    public void test02() {

        // 查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("uid");
        List<User> userList = userMapper.selectList(queryWrapper);
        log.info("######## UserList :  {} #######", userList);
    }

    @Test
    public void test03() {

        // 删除邮箱地址为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int i = userMapper.delete(queryWrapper);
        log.info("######## i :  {} #######", i);
    }

    @Test
    public void test04() {

        // 将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20).
                like("user_name","a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("灾难");
        user.setEmail("passion@gmail.com");
        int i = userMapper.update(user,queryWrapper);
        log.info("######## i :  {} #######", i);
    }

    @Test
    public void test05() {

        // 将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        // lambda中的条件优先执行
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        User user = new User();
        user.setName("honghong");
        int i = userMapper.update(user,queryWrapper);
        log.info("######## i :  {} #######", i);
    }

    @Test
    public void test06() {

        // 查询用户的用户名，年龄，邮箱信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name","age","email");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        log.info("###### maps :  {} ######",maps);
    }

    @Test
    public void test07() {

        // 查询id小于等于100的用户信息
        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (uid IN (SELECT uid FROM t_user WHERE uid <= 100))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid","SELECT uid FROM t_user WHERE uid <= 100");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        log.info("###### maps :  {} ######",maps);
    }

    @Test
    public void test08() {

        // 将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        // UPDATE t_user SET user_name=?,email=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("user_name","a")
                .and(i->i.gt("age",20).or().isNull("email"));
        updateWrapper.set("user_name","hehe").set("email","hhehehea@gawfa.com");
        int i = userMapper.update(null, updateWrapper);
        log.info("######## i :  {} #######", i);
    }

    @Test
    public void test09() {

        String username = "e";
        Integer ageBegin = null;
        Integer ageEnd = 30;

        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ?)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)){
            // isNotBlank 判断某个字符传是否不为空字符串，不为null，不为空白符
            queryWrapper.like("user_name",username);
        }
        if (ageBegin != null){
            queryWrapper.ge("age",ageBegin);
        }
        if (ageEnd != null){
            queryWrapper.le("age",ageEnd);
        }
        List<User> userList = userMapper.selectList(queryWrapper);
        log.info("######## UserList :  {} #######", userList);
    }

    @Test
    public void test10() {

        String username = "e";
        Integer ageBegin = null;
        Integer ageEnd = 30;

        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ?)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username),"user_name",username)
                .ge(ageBegin != null,"age",ageBegin)
                .le(ageEnd != null,"age",ageEnd);
        List<User> userList = userMapper.selectList(queryWrapper);
        log.info("######## UserList :  {} #######", userList);
    }

    @Test
    public void test11() {

        String username = "e";
        Integer ageBegin = null;
        Integer ageEnd = 30;

        // SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ?)
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(ageBegin != null,User::getAge,ageBegin)
                .le(ageEnd != null,User::getAge,ageEnd);
        List<User> userList = userMapper.selectList(lambdaQueryWrapper);
        log.info("######## UserList :  {} #######", userList);
    }

    @Test
    public void test12() {

        // 将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        // UPDATE t_user SET user_name=?,email=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.like(User::getName,"a")
                .and(i->i.gt(User::getAge,20).or().isNull(User::getEmail));
        lambdaUpdateWrapper.set(User::getName,"hehe").set(User::getEmail,"hhehehea@gawfa.com");
        int i = userMapper.update(null, lambdaUpdateWrapper);
        log.info("######## i :  {} #######", i);
    }
}
