package com.sc.entity;

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
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {

    private Integer id;
    
    private String username;
    
    private String password;
    
    private String phone;
    
    private Date regDate;
    
    private Date lastLoginDate;



}