package com.sc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sc.entity.User;
import com.sc.dao.UserDao;
import com.sc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理表(User)表服务实现类
 *
 * @author makejava
 * @since 2020-06-12 17:42:51
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public IPage<User> queryAllByLimit(int offset, int limit,User bean) {
        Page<User> page = new Page<>(offset,limit);
        page.setRecords(this.userDao.queryAllByLimit(offset, limit, bean));
        return page;
    }

    @Override
    public List<User> queryAll(User bean) {
        return userDao.queryAll(bean);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(User user) {

        return this.userDao.update(user) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> ids) {
        if (ids == null || ids.size() == 0){
            return false;
        }
        StringBuffer sb = new StringBuffer("id in (");
        for(Integer item : ids){
            sb.append("'");
            sb.append(item);
            sb.append("',");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(")");

        return userDao.delete("flower.user",sb.toString()) > 0;
    }
}