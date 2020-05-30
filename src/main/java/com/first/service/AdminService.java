package com.first.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.first.entity.Admin;
import com.first.entity.AdminQuery;

import java.util.List;

/**
 * 管理员表(Admin)表服务接口
 *
 * @author makejava
 * @since 2020-05-28 09:01:46
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param bean 组件
     * @return 对象列表
     */
    IPage<Admin> queryAllByLimit(int offset, int limit, AdminQuery bean);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    int update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    boolean deleteById(List<Integer> ids);

    /**
     * 登录
     * @param account 帐号
     * @param password 密码
     * @return controller层
     */
    Admin login(String account, String password);

    /**
     * 查询所有
     * @param bean 组件
     * @return 所有数据
     */
    List<Admin> queryAll(AdminQuery bean);

}