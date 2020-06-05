package com.first.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.first.entity.Admin;
import com.first.entity.AdminQuery;
import com.first.entity.Student;
import com.first.entity.common.CommonResult;
import com.first.listener.StudentExcelListener;
import com.first.service.AdminService;
import com.first.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * 管理员表(Admin)表控制层
 *
 * @author makejava
 * @since 2020-05-28 09:01:47
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    @Resource
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Admin selectOne(Integer id) {
        return this.adminService.queryById(id);
    }

    /**
     * 插入
     * @param bean 组件
     * @return 插入的数据
     */
    @PostMapping("insert")
    @ResponseBody
    public Admin insert(Admin bean) {
        return adminService.insert(bean);
    }

    /**
     *  登录
     * @param account 帐号
     * @param password 密码
     * @param model 存储数据
     * @return 相对应页面
     */
    @PostMapping("login")
    public String login( @RequestParam("account") String account, String password, Model model,HttpSession session) {
        Admin admin = adminService.login(account, password);
        if (admin == null) {
            //登录不成功
            model.addAttribute("msg", "账号或密码错误");
           ;
            return "login";
        }

        //使用Cookie记住账号和密码

        //将用户信息存入到session
        session.setAttribute("admin",admin);
        session.setAttribute("loginUser",account);
        return "index";
    }

    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, AdminQuery bean) {

        CommonResult<Admin> result = new CommonResult<>();
        IPage<Admin> iPage = adminService.queryAllByLimit(page, limit, bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }

    /**
     *
     * @return 页面
     */
    @RequestMapping("toList")
    public String toList() {
        return "user/admin_list";
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

    @PostMapping("save")
    @ResponseBody
    public Object save(Admin bean) {
        boolean result = false;
        //判断账号是否存在

        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
            result = adminService.update(bean) > 0;
        } else {
            //添加
            bean.setRegDate(new Date());
            result = adminService.insert(bean).getId() != null;
        }

        return result;

    }

    @PostMapping("deleteById")
    @ResponseBody
    public boolean deleteById(Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
        adminService.deleteById(Arrays.asList(ids));
        return true;
    }

    @RequestMapping("toAdd")
    public String toAdd(Model model) {
        model.addAttribute("bean", new Admin());
        return "user/admin_add";
    }

    @RequestMapping("toEdit")
    public String toEdit(Integer id, Model model) {

        Admin bean = adminService.queryById(id);
        model.addAttribute("bean", bean);

        return "user/admin_add";
    }

}