package com.first.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.first.entity.Student;
import com.first.dao.StudentDao;
import com.first.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2020-05-30 16:09:38
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Integer id) {

        return this.studentDao.queryById(id);
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public IPage<Student> queryAllByLimit(int offset, int limit, Student bean) {
        Page<Student> page = new Page<>(offset, limit);
        page.setRecords(studentDao.queryAll(page, bean));
        return page;
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    @Override
    public int insert(List<Student> list) {
        return studentDao.insertBatch(list);
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Student student) {

        return this.studentDao.update(student);
    }

    @Override
    public boolean deleteById(List<Integer> ids) {
        return this.studentDao.deleteById(ids) > 0;
    }

    @Override
    public List<Student> queryAll(Student bean) { return null; }
}