package com.ren.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.ren.mybatis_plus.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: mybatis_plus
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-05 00:49
 * @description:
 **/
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
//@TableName("t_user")  /**  设置实体类所对应的表名  */
public class User {

    // 将属性所对应的字段指定为主键
    // vlue属性用于指定主键的字段
    // type属性设置主键生成策略
    // @TableId(value = "uid",type = IdType.AUTO)
    @TableId("uid")
    private Long id;

    @TableField("user_name")
    private String name;

    private Integer age;

    private SexEnum sex;

    private String email;

    @TableLogic  /** 表示逻辑删除的字段 */
    private Integer isDeleted;

    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
