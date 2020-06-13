package com.sc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Flower;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//@Component
//@FeignClient(value="provider-flower")//服务名称
public interface FlowerFeignService {
    //@GetMapping("/flower/queryAll")
    //List<Flower> queryAll();

    //@PostMapping("/flower/insert")
    Flower insert(Flower flower);

    //@PostMapping("/flower/update")
    int update(Flower flower);

    //@DeleteMapping("/flower/delete")
    boolean deleteById(List<Integer> ids);

    //@GetMapping("/flower/queryAll")
    IPage<Flower> queryAllByLimit(int offset, int limit, Flower bean);

}
