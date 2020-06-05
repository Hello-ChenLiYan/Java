package com.first.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.first.entity.SystemMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统菜单表(SystemMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-28 09:33:47
 */
@Mapper
@Repository
public interface SystemMenuDao extends BaseDao<SystemMenu> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SystemMenu queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param bean 实体
     * @return 对象列表
     */
    IPage<SystemMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,SystemMenu bean);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param page 实例对象
     * @param bean 实例对象
     * @return 对象列表
     */
    List<SystemMenu> queryAll(IPage<SystemMenu> page, SystemMenu bean);

    /**
     * 修改数据
     *
     * @param systemMenu 实例对象
     * @return 影响行数
     */
    int update(SystemMenu systemMenu);

}