package com.first.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 管理员表(Admin)实体类
 *
 * @author makejava
 * @since 2020-05-28 09:01:44
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = 868810321368045192L;
    
    private Integer id;
    /**
    * 账号
    */
    private String account;
    /**
    * 密码
    */
    private String password;
    /**
    * 手机号
    */
    private String mobile;
    /**
    * 注册时间
    */
    private Date regDate;
    /**
    * 最后一次登录
    */
    private Date lastLoginDate;
    /**
    * 1 启用 0 停用
    */
    private Integer isAllow;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getIsAllow() {
        return isAllow;
    }

    public void setIsAllow(Integer isAllow) {
        this.isAllow = isAllow;
    }

}