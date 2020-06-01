package com.first.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.first.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-30 16:09:38
 */
@Mapper
@Repository
public interface StudentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param bean 组件
     * @return 对象列表
     */
    List<Student> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,Student bean);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bean 实例对象
     * @param page 页面
     * @return 对象列表
     */
    List<Student> queryAll(IPage<Student> page, Student bean);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
     Student insert(Student student);

    /**
     * 批量插入
     * @param list 批量插入
     * @return 数据
     */
    int insertBatch(@Param("list") List<Student> list);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 影响行数
     */
    int deleteById(@Param("ids") List<Integer> ids);

}