package com.sc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true) //链式写法
@NoArgsConstructor //添加无参
@AllArgsConstructor //添加有参
public class Flower {

    private Integer id;
    private String name;
    private String type;
    private Integer stock;
    private Float price;
    private String floMean;
    private String photo;

}
