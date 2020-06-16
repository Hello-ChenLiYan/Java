package com.sc.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@ToString
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuVo {
    private Integer id;

    private Integer pid;

    private String title;

    private String icon;

    private String href;

    private String target;

    private List<MenuVo> child;


}