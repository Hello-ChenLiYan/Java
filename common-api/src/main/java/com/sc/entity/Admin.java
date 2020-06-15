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
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-06-12 21:46:30
 */
@Data
@ToString
@Accessors(chain = true)
//@NoArgsConstructor
//@AllArgsConstructor
@Table("florist.admin")
public class Admin implements Serializable {
    //Serializable简单的标识一个类的对象可以被序列化

    @Id
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String phone;
    
    private Date regDate;
    
    private Date lastLoginDate;



}