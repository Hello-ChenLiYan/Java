package com.sc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Admin;
import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2020-06-12 21:49:30
 */
public interface AdminService {


    Admin queryById(Integer id);

    List<Admin> queryAll(IPage<Admin> page, Admin bean);



}