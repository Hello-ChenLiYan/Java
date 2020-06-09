package com.sc.service.impl;

import com.sc.dao.BanjiDao;
import com.sc.entity.Banji;
import com.sc.service.BanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanjiServiceImpl implements BanjiService {
    @Autowired
    private BanjiDao banjiDao;

    @Override
    public boolean insert(Banji bean) {
        return banjiDao.insert(bean);
    }

    @Override
    public List<Banji> queryAll() {
        return banjiDao.queryAll();
    }
}
