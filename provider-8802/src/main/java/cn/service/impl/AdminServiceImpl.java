package cn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.dao.AdminDao;
import cn.entity.Admin;
import cn.entity.AdminQuery;
import cn.service.AdminService;
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
    public IPage<Admin> queryAllByLimit(int offset, int limit, AdminQuery bean) {
        Page<Admin> page = new Page<>(offset, limit);
        QueryWrapper<Admin> wrapper = new QueryWrapper();

        wrapper.like("username", bean.getUsername())
                .eq("phone", bean.getPhone())
                .gt("reg_date", bean.getStartTime())
                .lt("reg_date", bean.getEndTime());

        page.setRecords(adminDao.queryAll(page,bean));

        return page;
    }

    @Override
    public boolean delete(List<Integer> ids) {
        return adminDao.delete(ids);
    }

    @Override
    public Admin insert(Admin bean) {
        this.adminDao.insert(bean);
        return bean;
    }

    @Override
    public int update(Admin bean) {
        return adminDao.update(bean);
    }


}