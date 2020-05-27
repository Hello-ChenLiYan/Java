package com.xh.service.impl;

import com.xh.entity.User;
import com.xh.dao.UserDao;
import com.xh.poi.excel.ExcelUtil;
import com.xh.service.UserService;
import com.xh.util.ResultObjStr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-05-28 00:43:23
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserDao userDao) {
        this.userDao=userDao;
    }

    @Override
    public ResultObjStr importExcel(MultipartFile file, Integer id) {
        List<Map<String, Object>> excelsMap = new ArrayList<>();
        InputStream in = null;
        try {
            in = file.getInputStream();
            List<List<Object>> excels = ExcelUtil.readExcel(in);
            for (List<Object> excel : excels) {
                Map<String, Object> map = new HashMap<>();
                for (int j = 0; j < excel.size(); j++) {
                    switch (j) {
                        case 0:
                            map.put("stu_number", excel.get(j));
                            break;
                        case 1:
                            map.put("name", excel.get(j));
                            break;
                        case 2:
                            map.put("other", excel.get(j));
                            break;
                        default:
                            break;
                    }

                }
                excelsMap.add(map);
            }
            this.userDao.addMultUser(excelsMap);
            return new ResultObjStr(ResultObjStr.SUCCESS, "上传成功", null);
        } catch (IOException e) {
            logger.error("导入 siteInfo excel 错误 : " + e.getMessage());
            return new ResultObjStr(ResultObjStr.ERROR, "上传错误", null);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                logger.error("导入 siteInfo excel 关流错误 : " + e.getMessage());
            }
        }
    }

    @Override
    public ResultObjStr exportExcel(Integer id, String fileName, String excelFormat, OutputStream fileOut) {
        List<Map<String, Object>> allSiteInfos = this.userDao.getDataOfExportExcel();
        List<List<Object>> excels = new ArrayList<>();
        for (Map<String, Object> map : allSiteInfos) {
            List<Object> row = new ArrayList<>();
            String stuNumber = map.get("stu_number").toString();
            String name1 = map.get("name").toString();
            String other = map.get("other").toString();
            if (name1.length() > 3200) {
                name1= name1.substring(0, 3200);
            }
            row.add(stuNumber);
            row.add(name1);
            row.add(other);
            excels.add(row);
        }
        ExcelUtil.exportExcel(excels, fileName, excelFormat, fileOut);
        return new ResultObjStr(ResultObjStr.SUCCESS, "下载成功", null);
    }
}