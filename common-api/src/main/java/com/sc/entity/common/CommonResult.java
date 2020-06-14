package com.sc.entity.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true) //链式写法
@NoArgsConstructor //添加无参
public class CommonResult {

    private int code;
    private String msg;
    private Long count;
    private Object data;

}
