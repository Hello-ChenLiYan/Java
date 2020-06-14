package com.sc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Admin;
import com.sc.dao.AdminDao;
import com.sc.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2020-06-12 21:49:30
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

    @Override
    public List<Admin> queryAll(IPage<Admin> page, Admin bean) {
        return adminDao.queryAll(page, bean);
    }


}