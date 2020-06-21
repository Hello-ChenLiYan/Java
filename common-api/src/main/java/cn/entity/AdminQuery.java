package cn.entity;

import cn.annotation.Table;
import lombok.*;
import lombok.experimental.Accessors;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table("florist.admin")
public class AdminQuery extends Admin {
    private String startTime;
    private String endTime;

}
