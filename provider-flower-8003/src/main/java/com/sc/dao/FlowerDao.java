package com.sc.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Flower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FlowerDao extends BaseDao<Flower> {

//    Flower getByBean(Flower bean);
    List<Flower> getByName(String name);
//    Flower selectByName(String name);
    Flower queryById(Integer id);
//    List<Flower> getByKeys(String key);
    List<Flower>queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, Flower bean);
    List<Flower> queryAll(IPage<Flower> page, Flower bean);
//    boolean insertFlower(Flower bean);
//    boolean deleteById(Integer id);
//    boolean updateById(Flower bean);

}
