package com.sc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Flower;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface FlowerService {

    Flower queryById(Integer id);
    Flower insert(Flower flower);
    int update(Flower flower);
    boolean deleteById(List<Integer> ids);
    IPage<Flower> queryAllByLimit(int offset, int limit, Flower bean);

}
