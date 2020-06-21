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
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-06-19 10:45:38
 */
@Table("florist.admin")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Admin implements Serializable {
    @Id
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String phone;
    
    private Date regDate;
    
    private Date lastLoginDate;
}