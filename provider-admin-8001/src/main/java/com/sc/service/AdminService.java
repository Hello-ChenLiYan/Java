package com.sc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Admin;
import com.sc.entity.AdminQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2020-06-12 21:49:30
 */
public interface AdminService {


    Admin queryById(Integer id);
    IPage<Admin> queryAllByLimit( int offset,  int limit,  AdminQuery bean);
    boolean delete(List<Integer> ids);
    Admin insert(Admin bean);
    int update(Admin bean);





}