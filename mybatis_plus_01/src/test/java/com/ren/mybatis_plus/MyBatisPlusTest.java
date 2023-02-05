package com.ren.mybatis_plus;

import com.ren.mybatis_plus.mapper.UserMapper;
import com.ren.mybatis_plus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mybatis_plus
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-05 00:59
 * @description:
 **/
@Slf4j
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {

        List<User> userList = userMapper.selectList(null);
        log.info("#####  ##### UserList:{}",userList);
    }

    @Test
    public void testInsert() {

        // 新增用户信息
        // INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User("lili",12,"eajml.coa");
        int i = userMapper.insert(user);
        log.info("######## result {} ##############",i);
        log.info("######## userId {} ##############",user.getId());
    }

    @Test
    public void testDelete() {
       /* int i = userMapper.deleteById(1621923340639801346L);
        log.info("######## result {} ##############",i);*/

        // ==>  DELETE FROM user WHERE name = ? AND age = ?
        // ==>  Tom(String), 21(String)
        /*HashMap<String, Object> map = new HashMap<>();
        map.put("name","Tom");
        map.put("age","21");
        int i = userMapper.deleteByMap(map);
        log.info("######## result {} ##############",i);*/

        // ==> DELETE FROM user WHERE id IN ( ? , ? , ? )
        // ==> 1(Long), 2(Long), 3(Long)
        List<Long> idList = Arrays.asList(4L, 5L, 6L);
        int i = userMapper.deleteBatchIds(idList);
        log.info("######## result {} ##############",i);
    }

    @Test
    public void testUpdate() {

        // 修改用户信息 根据id
        // ==> UPDATE user SET name=?, age=?, email=? WHERE id=?
        // ==> lilite(String), 23(Integer), machsh Ren(String), 4(Long)
        //User user = new User(4L,"lilite",23,"machsh Ren",0);
        //int i = userMapper.updateById(user);
        //log.info("######## result {} ##############",i);
    }

    @Test
    public void testSelect() {

        // 通过id查询用户信息
        // ==>  SELECT id,name,age,email FROM user WHERE id=?
        // ==>  2(Long)
        /*User user = userMapper.selectById(2L);
        log.info("#####  ##### User:{}",user);*/

        // 根据多个id查询多个用户信息
        // ==>  SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        // ==>  1(Long), 2(Long), 3(Long)
        /*List<Long> idList = Arrays.asList(1L, 2L, 3L);
        List<User> userList = userMapper.selectBatchIds(idList);
        log.info("#####  ##### UserList:{}",userList);*/

        // 根据map集合中的条件执行查询
        // ==>  SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        // ==>  Jack(String), 20(Integer)
        /*HashMap<String, Object> map = new HashMap<>();
        map.put("name","Jack");
        map.put("age",20);
        List<User> userList = userMapper.selectByMap(map);
        log.info("#####  ##### UserList:{}",userList);*/

        /*List<User> userList = userMapper.selectList(null);
        log.info("#####  ##### UserList:{}",userList);*/

        Map<String, Object> map = userMapper.selectMapById(1L);
        log.info("#####  ##### Map:{}",map);
    }
}
