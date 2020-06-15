/*
package com.sc.dao;

import com.sc.util.MySqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

public interface BaseDao<T> {

    @InsertProvider(type = MySqlProvider.class, method = MySqlProvider.INSERT)
    int insert(T bean);

  */
/*  @DeleteProvider(type = MySqlProvider.class, method = MySqlProvider.DELETE)
    int delete(@Param("table") String table, @Param("where") String where);*//*


    @UpdateProvider(type = MySqlProvider.class, method = MySqlProvider.UPDATE)
    int update(T bean);

}

*/
