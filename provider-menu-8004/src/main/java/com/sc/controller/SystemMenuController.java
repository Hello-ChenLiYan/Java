package com.sc.controller;

import com.sc.entity.SystemMenu;
import com.sc.service.SystemMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * 系统菜单表(SystemMenu)表控制层
 *
 * @author makejava
 * @since 2020-05-27 15:56:18
 */
@RestController
@RequestMapping("systemMenu")
public class SystemMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SystemMenuService systemMenuService;

    @GetMapping("getById")
    public Object queryById(Integer id){
        return this.systemMenuService.queryById(id);
    }

    @PostMapping("save")
    @ResponseBody
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
        }
        return result;
    }

}