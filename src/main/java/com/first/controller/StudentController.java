package com.first.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.first.entity.Admin;
import com.first.entity.AdminQuery;
import com.first.entity.Student;
import com.first.entity.common.CommonResult;
import com.first.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2020-05-30 16:09:39
 */
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Student selectOne(Integer id) {
        return this.studentService.queryById(id);
    }

    /**
     *
     * @return 页面
     */
    @RequestMapping("toList")
    public String toList() {
        return "user/student_list";
    }

    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, Student bean) {

        CommonResult<Admin> result = new CommonResult<>();
        IPage<Student> iPage = studentService.queryAllByLimit(page,limit,bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }
}