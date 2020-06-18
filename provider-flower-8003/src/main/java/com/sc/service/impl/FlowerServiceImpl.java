package com.sc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sc.dao.FlowerDao;
import com.sc.entity.Flower;
import com.sc.service.FlowerService;
import com.sc.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("flowerService")
public class FlowerServiceImpl implements FlowerService {

    //@Autowired
    @Resource
    private FlowerDao flowerDao;

    @Override
    public Flower queryById(Integer id) {
        return flowerDao.queryById(id);
    }

    @Override
    public Flower insert(Flower flower) {
        this.flowerDao.insert(flower);
        return flower;
    }

    @Override
    public int update(Flower flower) {
        return flowerDao.update(flower);
    }

    @Override
    public boolean deleteById(List<Integer> ids) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        map.put("id",ids);
        return flowerDao.delete(map);
    }

    @Override
    public IPage<Flower> queryAllByLimit(int offset, int limit, Flower bean) {
        Page<Flower> page = new Page<>(offset,limit);
        page.setRecords(flowerDao.queryAll(page,bean));
        return page;
    }

    @Override
    public List<Flower> queryAll(Flower bean) {
        return flowerDao.queryAll(bean);
    }

    @Override
    public List<Flower> getByKeys(String key) {
        return flowerDao.getByKeys(key);
    }
}
