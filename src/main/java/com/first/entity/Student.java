package com.first.entity;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-05-30 16:09:38
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -98832085616542246L;
    
    private Integer id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 学号
    */
    private String code;
    /**
    * 班级名称
    */
    private String className;
    /**
    * 班级id
    */
    private Integer classId;
    /**
    * 手机号
    */
    private String mobile;
    /**
    * 性别：1 男，0 女
    */
    private Integer gender;
    /**
    * 备注
    */
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}