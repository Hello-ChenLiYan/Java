package cn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.dao.SystemMenuDao;
import cn.entity.MenuVo;
import cn.entity.SystemMenu;
import cn.service.SystemMenuService;
import cn.util.TreeUtil;
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
 * @since 2020-05-27 16:47:34
 */
@Service("systemMenuService")
public class SystemMenuServiceImpl implements SystemMenuService {
    @Resource
    private SystemMenuDao systemMenuDao;

    @Override
    public Map<String, Object> queryAll() {
        Page<SystemMenu> page = new Page<>();
        SystemMenu bean = new SystemMenu();
        Map<String, Object> map = new HashMap<>(16);
        Map<String,Object> home = new HashMap<>(16);
        Map<String,Object> logo = new HashMap<>(16);
        List<SystemMenu> menuList = systemMenuDao.queryAll(page,bean);
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
        home.put("href","welcome");
        //控制器路由,自行定义
        logo.put("title","后台管理系统");
        logo.put("image","images/logo.png");
        //静态资源文件路径,可使用默认的logo.png
        map.put("homeInfo", "{title: '首页',href: 'welcome'}");
        map.put("logoInfo", "{title: 'RUGE ADMIN',image:'images/logo.png'}");
        return map;
    }

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



    @Override
    public IPage<SystemMenu> queryAllByLimit(int offset, int limit, SystemMenu bean) {
        Page<SystemMenu> page = new Page<>(offset, limit);
        QueryWrapper<SystemMenu> wrapper = new QueryWrapper();

        wrapper.eq("pid", bean.getPid())
                .like("title", bean.getTitle());
        page.setRecords(systemMenuDao.queryAll(page,bean));

        return page;
    }


    @Override
    public SystemMenu insert(SystemMenu bean) {
        bean.setStatus(1);
        bean.setTarget("_self");
        this.systemMenuDao.insert(bean);
        return bean;
    }


    @Override
    public boolean update(SystemMenu bean) {
        return systemMenuDao.update(bean)>0;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        return systemMenuDao.delete(ids);
    }
}