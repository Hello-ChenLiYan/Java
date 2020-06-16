package com.sc.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-12 21:49:30
 */
@Mapper
@Repository
public interface AdminDao  {

    Admin queryById(Integer id);
    List<Admin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    List<Admin> queryAll(IPage<Admin> page, @Param("bean") Admin bean);
    boolean delete(@Param("ids") List<Integer> ids);
    int insert(Admin bean);
    int update(Admin bean);


}