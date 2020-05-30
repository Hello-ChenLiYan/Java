package com.first.controller;

import com.first.entity.SystemMenu;
import com.first.service.SystemMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 系统菜单表(SystemMenu)表控制层
 *
 * @author makejava
 * @since 2020-05-28 09:33:47
 */
@RestController
@RequestMapping("systemMenu")
public class SystemMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SystemMenuService systemMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SystemMenu selectOne(Integer id) {
        return this.systemMenuService.queryById(id);
    }

    @GetMapping("queryAll")
    public Map<String, Object> queryAll() {
        return systemMenuService.queryAll();
    }

}