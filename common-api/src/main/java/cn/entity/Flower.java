package cn.entity;

import cn.annotation.Id;
import cn.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Flower)实体类
 *
 * @author makejava
 * @since 2020-06-19 10:46:14
 */
@Table("florist.flower")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Flower implements Serializable {

    @Id
    private Integer id;
    
    private String name;
    
    private String type;
    
    private Integer stock;
    
    private Double price;
    
    private String floMean;
    
    private String photo;

}