package com.sc.dao;

import com.sc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户管理表(User)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-12 17:42:50
 */
@Mapper
@Repository
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("bean") User bean);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bean 实例对象
     * @return 对象列表
     */
    List<User> queryAll(@Param("bean") User bean);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 影响行数
     */
    int delete(@Param("ids") List<Integer> ids);


}