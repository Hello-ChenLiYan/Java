package com.first.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.first.entity.Laboratory;

import java.util.List;

/**
 * 实验室记录(Laboratory)表服务接口
 *
 * @author makejava
 * @since 2020-06-07 22:10:20
 */
public interface LaboratoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @param bean 实体
     * @return 实例对象
     */
    Laboratory queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param bean 实体
     * @return 对象列表
     */
    IPage<Laboratory> queryAllByLimit(int offset, int limit,Laboratory bean);

    /**
     * 新增数据
     *
     * @param bean 实例对象
     * @return 实例对象
     */
    Laboratory insert(Laboratory bean);

    /**
     * 修改数据
     *
     * @param bean 实例对象
     * @return 实例对象
     */
    boolean update(Laboratory bean);

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    boolean deleteById(List<Integer> ids);

}