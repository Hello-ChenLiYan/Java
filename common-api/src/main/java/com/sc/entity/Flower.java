package com.sc.entity;

import com.sc.annotation.Id;
import com.sc.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true) //链式写法
//@NoArgsConstructor //添加无参
//@AllArgsConstructor //添加有参
@Table("florist.flower")
public class Flower implements Serializable {

    @Id
    private Integer id;
    private String name;
    private String type;
    private Integer stock;
    private Float price;
    private String floMean;
    private String photo;

}