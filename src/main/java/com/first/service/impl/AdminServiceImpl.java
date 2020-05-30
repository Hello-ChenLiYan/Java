package com.first.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.first.entity.Admin;
import com.first.dao.AdminDao;
import com.first.entity.AdminQuery;
import com.first.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员表(Admin)表服务实现类
 *
 * @author makejava
 * @since 2020-05-28 09:01:46
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Integer id) {
        return this.adminDao.queryById(id);
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public IPage<Admin> queryAllByLimit(int offset, int limit, AdminQuery bean) {
        Page<Admin> page = new Page<>(offset, limit);
        QueryWrapper<Admin> wrapper = new QueryWrapper();
        wrapper.like("account", bean.getAccount())
                .eq("mobile", bean.getMobile())
                .gt("reg_date", bean.getStartTime())
                .lt("reg_date", bean.getEndTime());

        page.setRecords(adminDao.queryAll(page, bean));

        return page;
    }


    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Admin admin) {
        this.adminDao.update(admin);
        return this.adminDao.update(admin);
    }

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> ids) {
        System.out.println(ids);
        return adminDao.deleteById(ids) > 0;
    }

    @Override
    public Admin login(String account, String password) {
        return adminDao.login(account, password);
    }

    @Override
    public List<Admin> queryAll(AdminQuery bean) {
        return null;
    }

}