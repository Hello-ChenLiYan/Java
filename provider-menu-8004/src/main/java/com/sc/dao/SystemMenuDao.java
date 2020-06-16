package com.sc.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.SystemMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统菜单表(SystemMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-27 15:56:18
 */
@Mapper
@Repository
public interface SystemMenuDao extends BaseDao<SystemMenu> {
    SystemMenu queryById(Integer id);
}