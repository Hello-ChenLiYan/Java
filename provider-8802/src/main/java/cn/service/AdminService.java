package cn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.entity.Admin;
import cn.entity.AdminQuery;
import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2020-06-12 21:49:30
 */
public interface AdminService {


    Admin queryById(Integer id);
    IPage<Admin> queryAllByLimit(int offset, int limit, AdminQuery bean);
    boolean delete(List<Integer> ids);
    Admin insert(Admin bean);
    int update(Admin bean);





}