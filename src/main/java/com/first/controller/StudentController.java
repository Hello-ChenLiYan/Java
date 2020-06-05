package com.first.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.first.entity.Student;
import com.first.entity.common.CommonResult;
import com.first.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.first.listener.StudentExcelListener;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2020-05-30 16:09:39
 */
@Controller
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

        CommonResult<Student> result = new CommonResult<>();
        IPage<Student> iPage = studentService.queryAllByLimit(page,limit,bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }

    @PostMapping("insert")
    @ResponseBody
    public Student insert(Student bean){
        return studentService.insert(bean);
    }

    @PostMapping("deleteById")
    @ResponseBody
    public boolean deleteById(Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
        studentService.deleteById(Arrays.asList(ids));
        return true;
    }

    /**
     *
     * @param model student实体类
     * @return 页面
     */
    @RequestMapping("toAdd")
    //@RequestMapping("/")
    public String toAdd(Model model) {
        model.addAttribute("bean", new Student());
        return "user/student_add";
    }

    @RequestMapping("toEdit")
    public String toEdit(Integer id, Model model) {
        Student bean = studentService.queryById(id);
        model.addAttribute("bean", bean);

        return "user/student_add";
    }

    @PostMapping("save")
    @ResponseBody
    public Object save(Student bean) {
        boolean result = false;
        //判断账号是否存在

        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
            result = studentService.update(bean) > 0;
        } else {
            //添加

            result = studentService.insert(bean).getId() != null;
        }

        return result;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     *
     */
    @GetMapping("getById")
    @ResponseBody
    public Student getById(Integer id) {
        return this.studentService.queryById(id);
    }

    /**
     * 文件上传
     * @param file 文件
     * @return 数据
     */
    @PostMapping("upload")
    @ResponseBody
    public Object upload(MultipartFile file) {
        CommonResult<String> result = new CommonResult<>();
        try {
            EasyExcel.read(file.getInputStream(), Student.class, new StudentExcelListener(studentService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
            result.setMsg("Excel上传出错");
        }
        result.setData(file.getOriginalFilename());
        return result;
    }
}