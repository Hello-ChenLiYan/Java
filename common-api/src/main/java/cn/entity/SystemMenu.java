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
 * 系统菜单表(SystemMenu)实体类
 *
 * @author makejava
 * @since 2020-06-19 10:46:48
 */
@Data
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table("florist.system_menu")
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