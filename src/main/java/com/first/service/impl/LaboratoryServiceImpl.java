package com.first.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.first.dao.LaboratoryDao;
import com.first.entity.Laboratory;
import com.first.service.LaboratoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 实验室记录(Laboratory)表服务实现类
 *
 * @author makejava
 * @since 2020-06-07 22:10:20
 */
@Service("laboratoryService")
public class LaboratoryServiceImpl implements LaboratoryService {
    @Resource
    private LaboratoryDao laboratoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Laboratory queryById(Integer id) {

        return this.laboratoryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public IPage<Laboratory> queryAllByLimit(int offset, int limit, Laboratory bean) {
        Page<Laboratory> page = new Page<>(offset, limit);
        page.setRecords(laboratoryDao.queryAllByLimit(offset,limit,bean));
        System.out.println("page="+page.getRecords());
        return page;
    }

    /**
     * 新增数据
     *
     * @param laboratory 实例对象
     * @return 实例对象
     */
    @Override
    public Laboratory insert(Laboratory laboratory) {
        this.laboratoryDao.insert(laboratory);
        return laboratory;
    }

    /**
     * 修改数据
     *
     * @param laboratory 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Laboratory laboratory) {

        return this.laboratoryDao.update(laboratory) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> ids) {
        if (ids == null || ids.size() == 0) {
            return false;
        }
        StringBuffer sb = new StringBuffer("id in (");
        for (Integer item : ids) {
            sb.append("'");
            sb.append(item);
            sb.append("',");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(")");
        return laboratoryDao.delete("boot.laboratory", sb.toString()) > 0;
    }
}