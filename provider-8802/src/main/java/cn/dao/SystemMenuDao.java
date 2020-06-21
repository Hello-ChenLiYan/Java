package cn.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.entity.SystemMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 系统菜单表(SystemMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-27 16:47:34
 */
@Mapper
@Repository
@ResponseBody
public interface SystemMenuDao extends BaseDao<SystemMenu>{

    SystemMenu queryById(@Param("id") Integer id);
    List<SystemMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    List<SystemMenu> queryAll(@Param("page") IPage<SystemMenu> page, @Param("bean") SystemMenu bean);
    boolean delete(@Param("ids") List<Integer> ids);

}