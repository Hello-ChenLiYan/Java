package com.sc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Admin;
import com.sc.entity.AdminQuery;
import com.sc.entity.common.CommonResult;
import com.sc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

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
    @GetMapping("getById")
    public Object getById(Integer id) {
        System.out.println("getbyid"+ id);
        return this.adminService.queryById(id);
    }



    @PostMapping("queryAll")
    public Object queryAll( Integer page,  Integer limit, @RequestBody AdminQuery bean) {
        System.out.println(page);
        System.out.println(limit);
        System.out.println("bean::" + bean);
        CommonResult<Admin> result = new CommonResult<>();
        IPage<Admin> iPage = adminService.queryAllByLimit(page, limit, bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }

   //编辑
//    @GetMapping("/{id}")
//    public String toEdit(@PathVariable(value = "id")  Integer id, Model model) {
//        System.out.println("id:::" + id);
//        Admin bean = adminService.queryById(id);
//        model.addAttribute("bean", bean);
//        return "user/admin_add";
//    }

    @PostMapping("save")
    public Object save(Admin bean) {
        boolean result = false;
        System.out.println("**************提高者的save方法**********************");
        System.out.println(bean);
        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
             result = adminService.update(bean)>0;
        } else {
            //添加
            result = adminService.insert(bean).getId()!= null;
        }

        return result;
    }

    @DeleteMapping("/{ids}")
    public boolean deleteById(@PathVariable Integer[] ids) {
        System.out.println("#################");
        System.out.println(ids);
        if (ids == null || ids.length == 0) {
            return false;
        }
        adminService.delete(Arrays.asList(ids));
        return true;
    }


}