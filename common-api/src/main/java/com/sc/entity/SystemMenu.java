package com.sc.entity;



import com.sc.annotation.Id;
import com.sc.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统菜单表(SystemMenu)实体类
 *
 * @author makejava
 * @since 2020-05-27 16:47:34
 */
@Table("florist.system_menu")
@Data
public class SystemMenu implements Serializable {
    /**
     * ID
     */
    @Id
    private Integer id;
    /**
     * 父ID
     */
    private Integer pid;
    /**
     * 名称
     */
    private String title;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 链接
     */
    private String href;
    /**
     * 链接打开方式
     */
    private String target;
    /**
     * 菜单排序
     */
    private Integer sort;
    /**
     * 状态(0:禁用,1:启用)
     */
    private Integer status;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;
    /**
     * 删除时间
     */
    private Date deleteAt;



}