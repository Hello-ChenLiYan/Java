package com.first.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.first.annotation.Id;
import com.first.annotation.Table;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 小胖
 */
public class MySqlProvider {

    public static final String INSERT = "insert";
    public static final String DELETE = "delete";
    public static final String UPDATE = "update";

    /**
     * 插入
     * @param obj 对象
     * @return 数据
     */
    public static String insert(Object obj){
        //获取表名
        String table = getTableName(obj);
        System.out.println(table);

        Map<String,String > map = new HashMap<>();
        getMap(obj,map);
        return new SQL(){
            {
                INSERT_INTO(table);
                for (String key : map.keySet()) {
                    VALUES(key, map.get(key));
                }
            }
        }.toString();
    }

    /**
     *  批量删除
     */
    public static String delete(String table, String where){
        if (StringUtils.isEmpty(table)){
            return null;
        }

        if (StringUtils.isEmpty(where)){
            return null;
        }

        return new SQL(){
            {
                DELETE_FROM(table);
                WHERE(where);
            }
        }.toString();
    }

    public static String update(Object obj) {
        Map<String, String> map = new HashMap<>();
        String table = getTableName(obj);
        String idName = getMap(obj, map);
        if (StringUtils.isEmpty(idName)) {
            throw new RuntimeException("实体类->" + obj.getClass().getCanonicalName() + "必须有@Id注解");
        }

        return new SQL(){
            {
                UPDATE(table);
                for (String key : map.keySet()) {
                    SET(key + "=" + map.get(key));
                }
                WHERE(idName + "=" + map.get(idName));
            }
        }.toString();
    }


    private static String  getTableName(Object obj){
        Class c = obj.getClass();
        Table table = (Table) c.getAnnotation(Table.class);
        if (table != null ) {
            return table.value();
        }
        return StringUtils.camelToUnderline(c.getSimpleName());
    }

    /**
     * 获取Id注解的属性
     * @param obj
     * @return
     */
    private static String getIdName(Field obj) {
        Class c = obj.getClass();
        Id id = (Id)c.getAnnotation(Id.class);
        if (id != null && !StringUtils.isEmpty(id.value())) {
            return id.value();
        }

        return StringUtils.camelToUnderline(obj.getName());
    }

    private  static String getMap(Object obj, Map<String, String> map) {
        //获取模板
        Class c = obj.getClass();
        //获取所有属性
        Field[] fs = c.getDeclaredFields();

        String idName = null;

        for (Field item : fs){
            //获取列属性名称
            String key = item.getName();
            //开启权限
            item.setAccessible(true);
            if (idName == null){
                idName = getIdName(item);
            }
            try{
                if (item.get(obj) != null){
                    //添加insert语句属性的键值对
                    map.put(StringUtils.camelToUnderline(key),"#{" + key + "}");
                }
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }
        return idName;
    }
}
