package com.sc.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sc.dao.SystemMenuDao;
import com.sc.entity.Admin;
import com.sc.entity.AdminQuery;
import com.sc.entity.SystemMenu;
import com.sc.service.SystemMenuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

/*
    @Override
    public List<SystemMenu> queryAll(IPage<SystemMenu> page, SystemMenu bean) {
        return systemMenuDao.queryAll(page, bean);
    }
*/

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

 /*   @Override
    public IPage<SystemMenu> queryAllByLimit(int offset, int limit, SystemMenu bean) {
        Page<SystemMenu> page = new Page<>(offset, limit);

        page.setRecords(systemMenuDao.queryAllByLimit(page, bean));
        return page;
    }*/

/*
    @Override
    public boolean delete(List<Integer> ids)
    {
        if(ids ==null || ids.size() ==0){
            return false;
        }
        StringBuffer sb =new StringBuffer("id in(");
        for(Integer item :ids){
            sb.append("'");
            sb.append(item);
            sb.append("',");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(")");
        return this.systemMenuDao.delete(ids);
    }*/

    @Override
    public boolean delete(List<Integer> ids) {
        return systemMenuDao.delete(ids);
    }
}