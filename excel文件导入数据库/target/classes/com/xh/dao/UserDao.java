package com.xh.dao;

import com.xh.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-28 00:43:23
 */
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 获取要下载的数据
     *
     * @return 对应数据列表
     */
    List<Map<String, Object>> getDataOfExportExcel();

    /**
     * 添加解析出来的Excel 文件数据
     *
     * @param list 数据列表
     *
     * @return 影响行数
     */
    Integer addMultUser(List<Map<String, Object>> list);

}