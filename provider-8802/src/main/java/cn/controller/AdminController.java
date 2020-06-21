package cn.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.entity.Admin;
import cn.entity.AdminQuery;
import cn.entity.common.CommonResult;
import cn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

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
    public Object queryAll(Integer page,  Integer limit, AdminQuery bean) {
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

    @PostMapping("save")
    public Object save(Admin bean) {
        boolean result = false;
        System.out.println(bean);
        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
             result = adminService.update(bean)>0;
        } else {
            //添加
            bean.setRegDate(new Date());
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