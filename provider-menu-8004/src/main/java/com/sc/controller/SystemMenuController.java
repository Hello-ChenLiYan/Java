package com.sc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.SystemMenu;
import com.sc.entity.common.CommonResult;
import com.sc.service.SystemMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * 系统菜单表(SystemMenu)表控制层
 *
 * @author makejava
 * @since 2020-05-27 16:47:34
 */
//@Controller
@RestController
@RequestMapping("systemMenu")
public class SystemMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SystemMenuService systemMenuService;

    @PostMapping("queryAll")
   // @ResponseBody
    public Object queryAll(Integer page, Integer limit, SystemMenu bean) {
        System.out.println(bean);
        CommonResult<SystemMenu> result = new CommonResult<>();
        IPage<SystemMenu> iPage = systemMenuService.queryAllByLimit(page, limit, bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }


        @DeleteMapping("/{ids}")
      //  @ResponseBody
        public boolean deleteById(@PathVariable Integer[] ids) {
            if (ids == null || ids.length == 0) {
                return false;
            }

             systemMenuService.delete(Arrays.asList(ids));
            return true;

        }

    @GetMapping("getById")
    public SystemMenu getById(Integer id){
        return this.systemMenuService.queryById(id);

    }

    @PostMapping("save")
   // @ResponseBody
    public Object save(SystemMenu bean){
        boolean result = false;
        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
            bean.setUpdateAt(new Date());
            result = systemMenuService.update(bean);
        } else {
            //添加
            bean.setCreateAt(new Date());
            result = systemMenuService.insert(bean).getId() != null;
            System.out.println("####添加#####"+bean);
        }
        return result;
    }

}