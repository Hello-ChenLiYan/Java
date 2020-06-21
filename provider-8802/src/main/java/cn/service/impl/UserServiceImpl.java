package cn.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.entity.User;
import cn.dao.UserDao;
import cn.service.UserService;
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
        IPage<User> page = new Page<>(offset,limit);
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

    @Override
    public boolean update(User user) {
        this.userDao.update(user);
        this.queryById(user.getId());
        return true;
    }


    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    @Override
    public boolean delete(List<Integer> ids) {
        return userDao.delete(ids) > 0;
    }

    @Override
    public User login(String account, String password) {
        return userDao.login(account, password);
    }
}