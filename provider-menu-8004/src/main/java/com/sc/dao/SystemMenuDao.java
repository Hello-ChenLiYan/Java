package com.sc.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.SystemMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统菜单表(SystemMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-27 16:47:34
 */
@Mapper
@ResponseBody
public interface SystemMenuDao extends BaseDao<SystemMenu>{

    SystemMenu queryById(Integer id);
   List<SystemMenu>queryAllByLimit(@Param("offset")int offset, @Param("limit") int limit);
    //  List<SystemMenu>queryAllByLimit(IPage<SystemMenu> page, SystemMenu bean);


    List<SystemMenu>queryAll(@Param("page")IPage<SystemMenu> page,@Param("bean")SystemMenu bean);
    boolean delete(@Param("ids") List<Integer> ids);

}