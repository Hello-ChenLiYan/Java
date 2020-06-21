package cn.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true) //链式写法
@NoArgsConstructor //添加无参
@AllArgsConstructor
public class CommonResult<T> {

    private int code;
    private String msg;
    private Long count;
    private Object data;

}
