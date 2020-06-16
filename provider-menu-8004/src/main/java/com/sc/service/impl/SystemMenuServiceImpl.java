package com.sc.service.impl;

import com.sc.dao.SystemMenuDao;
import com.sc.entity.SystemMenu;
import com.sc.service.SystemMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 系统菜单表(SystemMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-05-27 15:56:18
 */
@Service("systemMenuService")
public class SystemMenuServiceImpl implements SystemMenuService {

    @Resource
    private SystemMenuDao systemMenuDao;

    @Override
    public SystemMenu queryById(Integer id) {
        return this.systemMenuDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param systemMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SystemMenu insert(SystemMenu systemMenu) {
        systemMenu.setStatus(1);
        systemMenu.setTarget("_self");
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
    public boolean update(SystemMenu systemMenu) {
        return systemMenuDao.update(systemMenu)>0;
    }

}