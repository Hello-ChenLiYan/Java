package cn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.entity.SystemMenu;
import java.util.List;
import java.util.Map;

/**
 * 系统菜单表(SystemMenu)表服务接口
 *
 * @author makejava
 * @since 2020-05-27 16:47:34
 */
public interface SystemMenuService {

    /**
     * 查询所有
     * @return 所有数据
     */
    Map<String, Object> queryAll();

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