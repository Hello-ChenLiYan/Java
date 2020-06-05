package com.first.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.io.Serializable;

/**
 * 系统菜单表(SystemMenu)实体类
 *
 * @author makejava
 * @since 2020-05-28 09:33:47
 */
@Table("boot.system_menu")
public class SystemMenu implements Serializable {
    private static final long serialVersionUID = -84335113364900318L;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }
}