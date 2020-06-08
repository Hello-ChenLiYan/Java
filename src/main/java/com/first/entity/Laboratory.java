package com.first.entity;

import com.first.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;
import java.io.Serializable;

/**
 * 实验室记录(Laboratory)实体类
 *
 * @author makejava
 * @since 2020-06-08 15:25:50
 */
@Data
@Table("boot.laboratory")
@ToString
@Accessors
@NoArgsConstructor
@AllArgsConstructor
public class Laboratory implements Serializable {
    private static final long serialVersionUID = -83004131143287986L;
    
    private Integer id;
    /**
    * 学生
    */
    private String student;
    /**
    * 实验室
    */
    private String laboratory;
    /**
    * 课程
    */
    private String course;
    /**
    * 授课老师
    */
    private String teacher;
    /**
    * 开始时间
    */
    private Date starttime;
    /**
    * 离开时间
    */
    private Date endtime;
    /**
    * 备注
    */
    private String remark;

}