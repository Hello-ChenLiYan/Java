package com.sc.dao;

import com.sc.util.MySqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BaseDao<T> {

    @InsertProvider(type = MySqlProvider.class,method = MySqlProvider.INSERT)
    int insert(T bean);

    @DeleteProvider(type = MySqlProvider.class,method = MySqlProvider.DELETE)
    int delete(@Param("table") String table,@Param("where") String where);

    @UpdateProvider(type = MySqlProvider.class,method = MySqlProvider.UPDATE)
    int update(T bean);

}
