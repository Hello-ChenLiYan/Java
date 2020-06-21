package cn.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.entity.Flower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author
 */
@Mapper
@Repository
public interface FlowerDao extends BaseDao<Flower> {

    List<Flower> getByName(String name);
    Flower queryById(Integer id);
    List<Flower>queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, @Param("bean") Flower bean);
    List<Flower> queryAll(IPage<Flower> page, @Param("bean") Flower bean);
    List<Flower> queryAll(@Param("bean") Flower bean);
    boolean delete(Map<String, List<Integer>> maps);

}
