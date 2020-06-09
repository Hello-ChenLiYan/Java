package com.sc.service;


import com.sc.entity.Banji;

import java.util.List;

public interface BanjiService {

    boolean insert(Banji bean);

    List<Banji> queryAll();
}
