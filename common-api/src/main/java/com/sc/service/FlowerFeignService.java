package com.sc.service;

import com.sc.entity.Flower;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value="provider-flower")//服务名称
public interface FlowerFeignService {

    @GetMapping("/flower/getById")
    Flower getById(@RequestParam("id") Integer id);

    @PostMapping("/flower/queryAll")
    Object queryAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @RequestBody Flower bean);

    @PostMapping("/flower/save")
    Object save(@RequestBody Flower bean);

    @DeleteMapping("/flower/{ids}")
    boolean deleteById(@PathVariable(value = "ids") Integer[] ids);

}
