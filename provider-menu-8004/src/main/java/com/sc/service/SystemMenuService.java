package com.sc.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.SystemMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统菜单表(SystemMenu)表服务接口
 *
 * @author makejava
 * @since 2020-05-27 16:47:34
 */
public interface SystemMenuService {


   // List<SystemMenu>queryAll(IPage<SystemMenu> page,SystemMenu bean);

    SystemMenu queryById(Integer id);
    IPage<SystemMenu> queryAllByLimit(int offset, int limit, SystemMenu bean);

     boolean delete(List<Integer> ids);
    SystemMenu insert(SystemMenu systemMenu);

    /**
     * 修改数据
     *
     * @param systemMenu 实例对象
     * @return 实例对象
     */
    boolean update(SystemMenu systemMenu);



}