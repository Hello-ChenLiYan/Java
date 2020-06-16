package com.sc.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.MenuVo;
import com.sc.entity.SystemMenu;
import com.sc.entity.common.CommonResult;
import com.sc.service.SystemMenuService;
import com.sc.util.TreeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * 系统菜单表(SystemMenu)表控制层
 *
 * @author makejava
 * @since 2020-05-27 16:47:34
 */
@Controller
@RequestMapping("systemMenu")
public class SystemMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SystemMenuService systemMenuService;


 /*   @GetMapping("menus")
    @ResponseBody
    public Map<String, Object> menus() {
        Map<String, Object> map = new HashMap<>(16);
        Map<String,Object> home = new HashMap<>(16);
        Map<String,Object> logo = new HashMap<>(16);
        List<SystemMenu> menuList = systemMenuService.queryAll();
        List<MenuVo> menuInfo = new ArrayList<>();
        for (SystemMenu e : menuList) {
            MenuVo menuVO = new MenuVo();
            menuVO.setId(e.getId());
            menuVO.setPid(e.getPid());
            menuVO.setHref(e.getHref());
            menuVO.setTitle(e.getTitle());
            menuVO.setIcon(e.getIcon());
            menuVO.setTarget(e.getTarget());
            menuInfo.add(menuVO);
        }
        map.put("menuInfo", TreeUtil.toTree(menuInfo, 0));
        home.put("title","首页");
        home.put("href","/page/welcome-1");//控制器路由,自行定义
        logo.put("title","后台管理系统");
        logo.put("image","/static/images/back.jpg");//静态资源文件路径,可使用默认的logo.png
        map.put("homeInfo", "{title: '首页',href: '/ruge-web-admin/page/welcome.html'}}");
        map.put("logoInfo", "{title: 'RUGE ADMIN',image: 'images/logo.png'}");
        return map;
    }

    @GetMapping("getAuths")
    @ResponseBody
    public Object getAuths() {
        CommonResult<SystemMenu> result = new CommonResult<>();
        List<SystemMenu> list = systemMenuService.queryAll(page,bean);
        result.setCode(0);
        result.setCount((long) list.size());
        result.setData(list);

        return result;
    }
*/

    @PostMapping("queryAll")
    @ResponseBody
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
        @ResponseBody
        public boolean deleteById(@PathVariable Integer[] ids) {
            if (ids == null || ids.length == 0) {
                return false;
            }

             systemMenuService.delete(Arrays.asList(ids));
            return true;

        }
    }

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