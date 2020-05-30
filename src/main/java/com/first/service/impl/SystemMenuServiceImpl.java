package com.first.service.impl;

import com.first.entity.MenuVo;
import com.first.entity.SystemMenu;
import com.first.dao.SystemMenuDao;
import com.first.service.SystemMenuService;
import com.first.util.TreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统菜单表(SystemMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-05-28 09:33:47
 */
@Service("systemMenuService")
public class SystemMenuServiceImpl implements SystemMenuService {
    @Resource
    private SystemMenuDao systemMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SystemMenu queryById(Integer id) {
        return this.systemMenuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SystemMenu> queryAllByLimit(int offset, int limit) {
        return this.systemMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param systemMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SystemMenu insert(SystemMenu systemMenu) {
        this.systemMenuDao.insert(systemMenu);
        return systemMenu;
    }

    /**
     * 修改数据
     *
     * @param systemMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SystemMenu update(SystemMenu systemMenu) {
        this.systemMenuDao.update(systemMenu);
        return this.queryById(systemMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.systemMenuDao.deleteById(id) > 0;
    }

    @Override
    public Map<String, Object> queryAll() {
        Map<String, Object> map = new HashMap<>(16);
        Map<String,Object> home = new HashMap<>(16);
        Map<String,Object> logo = new HashMap<>(16);
        List<SystemMenu> menuList = systemMenuDao.queryAll(null);
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
        home.put("href","/admin/toWelcome");
        //控制器路由,自行定义
        logo.put("title","后台管理系统");
        logo.put("image","images/back.jpg");
        //静态资源文件路径,可使用默认的logo.png
        map.put("homeInfo", "{title: '首页',href: '/admin/toWelcome'}}");
        map.put("logoInfo", "{title: 'RUGE ADMIN',image: 'images/logo.png'}");
        return map;
    }
}