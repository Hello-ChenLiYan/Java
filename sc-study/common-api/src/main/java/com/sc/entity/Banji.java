package com.sc.entity;

import java.io.Serializable;

/**
 * (Banji)实体类
 *
 * @author makejava
 * @since 2020-06-09 10:40:23
 */
public class Banji implements Serializable {
    private static final long serialVersionUID = -41238403782403913L;
    
    private Integer id;
    
    private String name;
    
    private String db;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

}