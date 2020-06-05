package com.first.dao;

import com.first.entity.SystemMenu;
import com.first.util.MySqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author 小胖
 */
@Mapper
@Repository
public interface BaseDao<T> {
    /**
     * 新增数据
     *
     * @param bean 实例对象
     * @return 影响行数
     */
    @InsertProvider(type = MySqlProvider.class,method = MySqlProvider.INSERT)
    int insert(T bean);

    /**
     * 新增数据
     *
     * @param where 实例对象
     * @param table 实例对象
     * @return 影响行数
     */
    @DeleteProvider(type = MySqlProvider.class, method = MySqlProvider.DELETE)
    int delete(@Param("table") String table,@Param("where")  String where);
}
