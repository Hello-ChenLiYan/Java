package com.first.dao;

import com.first.entity.Laboratory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 实验室记录(Laboratory)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-07 22:10:20
 */
@Mapper
@Repository
public interface LaboratoryDao extends BaseDao<Laboratory>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @param bean 实体
     * @return 实例对象
     */
    Laboratory queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param bean 实体
     * @return 对象列表
     */
    List<Laboratory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("bean") Laboratory bean);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param laboratory 实例对象
     * @return 对象列表
     */
    List<Laboratory> queryAll(Laboratory laboratory);



}