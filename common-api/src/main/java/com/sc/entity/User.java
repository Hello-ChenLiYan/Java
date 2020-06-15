package com.sc.entity;

import com.sc.annotation.Id;
import com.sc.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户管理表(User)实体类
 *
 * @author makejava
 * @since 2020-06-12 11:31:11
 */
@Data
@ToString
@Accessors//(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table("flower.user")
public class User implements Serializable {
    /**
    * 用户ID
    */
    @Id
    private Integer id;
    /**
    * 用户账号
    */
    private String account;
    /**
    * 密码
    */
    private String password;
    /**
    * 昵称
    */
    private String pickName;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 性别
    */
    private Integer sex;
    /**
    * 联系方式
    */
    private String phone;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 地址
    */
    private String address;
    /**
    * 注册日期
    */
    private Date regDate;
    /**
    * 最后登录日期
    */
    private Date lastLoginDate;

}