package com.sc.dao;

import com.sc.entity.Banji;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BanjiDao {
    boolean insert(Banji bean);

    List<Banji> queryAll();
}
