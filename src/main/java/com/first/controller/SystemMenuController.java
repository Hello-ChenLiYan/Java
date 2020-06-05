package com.first.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.first.entity.SystemMenu;
import com.first.entity.common.CommonResult;
import com.first.service.SystemMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 系统菜单表(SystemMenu)表控制层
 *
 * @author makejava
 * @since 2020-05-28 09:33:47
 */
@Controller
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

    @RequestMapping("toList")
    public String toList(){
        return "menu/menu_list";
    }

    @GetMapping("menus")
    @ResponseBody
    public Map<String, Object> menus() {
        return systemMenuService.queryAll();
    }

    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, SystemMenu bean) {

        CommonResult<SystemMenu> result = new CommonResult<>();
        IPage<SystemMenu> iPage = systemMenuService.queryAllByLimit(page, limit, bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }

    @PostMapping("save")
    @ResponseBody
    public Object save(SystemMenu bean){

        boolean result = false;
        //判断账号是否存在

        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
            result = systemMenuService.update(bean).getId() > 0;
        } else {
            //添加
            result = systemMenuService.insert(bean).getId() != null;
        }
        return result;
    }

    /**
     *
     * @param model student实体类
     * @return 页面
     */
    @GetMapping("/toAdd")
    public String toAdd(Model model) {
        model.addAttribute("bean", new SystemMenu());
        return "menu/menu_add";
    }

}