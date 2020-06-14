package com.sc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sc.dao.FlowerDao;
import com.sc.entity.Flower;
import com.sc.service.FlowerFeignService;
import com.sc.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FlowerFeignServiceImpl implements FlowerFeignService {

    @Autowired
    private FlowerDao flowerDao;

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
        return flowerDao.delete("florist.flower", StringUtil.listToString(ids)) > 0;
    }

    @Override
    public IPage<Flower> queryAllByLimit(int offset, int limit, Flower bean) {
        Page<Flower> page = new Page<>(offset,limit);
//        QueryWrapper<Flower> wrapper = new QueryWrapper<>();
//        wrapper.like("name",bean.getName())
//        .like("type",bean.getType());
        page.setRecords(flowerDao.queryAll(page,bean));
        return page;
    }
}
