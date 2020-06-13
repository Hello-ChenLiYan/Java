package com.sc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Admin;
import com.sc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-06-12 21:49:30
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Autowired
    private AdminService adminService;

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

    @GetMapping("queryAll")
    public  Object queryAll(IPage<Admin> page, Admin bean){
        return adminService.queryAll(page,bean);
    }




}