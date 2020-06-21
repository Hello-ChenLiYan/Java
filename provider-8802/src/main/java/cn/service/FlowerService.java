package cn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.entity.Flower;

import java.util.List;

public interface FlowerService {

    Flower queryById(Integer id);
    Flower insert(Flower flower);
    int update(Flower flower);
    boolean deleteById(List<Integer> ids);
    IPage<Flower> queryAllByLimit(int offset, int limit, Flower bean);
    List<Flower> queryAll(Flower bean);

}
