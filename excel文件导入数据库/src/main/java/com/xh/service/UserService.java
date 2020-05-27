package com.xh.service;

import com.xh.entity.User;
import com.xh.util.ResultObjStr;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-05-28 00:43:23
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 导入 Excel
     *
     * @param file 文件流
     * @param myId id
     *
     * @return 统一返回
     */
    ResultObjStr importExcel(MultipartFile file, Integer id);

    /**
     * 导出 Excel
     *
     * @param myId        id
     * @param fileName    文件名称
     * @param excelFormat Excel 格式
     * @param fileOut     输出流
     *
     * @return 统一返回
     */
    ResultObjStr exportExcel(Integer id, String fileName, String excelFormat, OutputStream fileOut);

}