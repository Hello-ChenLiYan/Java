package cn.entity;

import cn.annotation.Id;
import cn.annotation.Table;
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
 * @since 2020-06-19 10:46:56
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table("florist.user")
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