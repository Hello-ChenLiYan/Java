package com.sc.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Flower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author yinrui
 */
@Mapper
@Repository
public interface FlowerDao extends BaseDao<Flower> {

    List<Flower> getByName(String name);
    Flower queryById(Integer id);
    List<Flower>queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, @Param("bean") Flower bean);
    List<Flower> queryAll(IPage<Flower> page, @Param("bean") Flower bean);
    List<Flower> queryAll(@Param("bean") Flower bean);
    List<Flower> getByKeys(@Param("key")String key);
    boolean delete(Map<String, List<Integer>> maps);


}
