package com.sc.entity;


import com.sc.annotation.Table;
import lombok.Data;
import lombok.ToString;

@Table("florist.admin")
@Data
@ToString
public class AdminQuery extends Admin {
    private String startTime;
    private String endTime;



}
