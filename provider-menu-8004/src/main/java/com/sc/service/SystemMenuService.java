package com.sc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.SystemMenu;

import java.util.List;

/**
 * 系统菜单表(SystemMenu)表服务接口
 *
 * @author makejava
 * @since 2020-05-27 15:56:18
 */
public interface SystemMenuService {

    SystemMenu queryById(Integer id);
    /**
     * 新增数据
     *
     * @param systemMenu 实例对象
     * @return 实例对象
     */
    SystemMenu insert(SystemMenu systemMenu);

    /**
     * 修改数据
     *
     * @param systemMenu 实例对象
     * @return 实例对象
     */
    boolean update(SystemMenu systemMenu);

}