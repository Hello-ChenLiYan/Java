package com.first.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.first.entity.Student;
import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author makejava
 * @since 2020-05-30 16:09:38
 */
public interface StudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param bean 组件
     * @return 对象列表
     */
    IPage<Student> queryAllByLimit(int offset, int limit, Student bean);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     *  插入
     * @param student 学生
     * @return 数据
     */
    int insert(List<Student> student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(List<Integer> id);

    /**
     * 查询所有
     * @param bean 组件
     * @return 所有数据
     */
    List<Student> queryAll(Student bean);

}