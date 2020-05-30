package com.first.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.first.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员表(Admin)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-28 09:01:45
 */
@Mapper
@Repository
public interface AdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param bean 组件
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, Admin bean);

    /**
     * 通过实体作为筛选条件查询
     * @param page 页面
     * @param bean 实例对象
     * @return 对象列表
     */
    List<Admin> queryAll(IPage<Admin> page, Admin bean);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 影响行数
     */
    int update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 影响行数
     */
    int deleteById(@Param("ids") List<Integer> ids);

    /**
     * 登录
     * @param account 账号
     * @param password 密码
     * @return service层
     */
    Admin login(@Param("account") String account, @Param("password") String password);

}