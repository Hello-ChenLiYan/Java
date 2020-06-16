package com.sc.service;

import com.sc.entity.SystemMenu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value="provider-systemMenu")
public interface SystemMenuFeignService {

    @GetMapping("systemMenu/getById")
    SystemMenu queryById(@RequestParam("id")Integer id);

    @PostMapping("systemMenu/save")
    Object save(@RequestBody SystemMenu bean);

}
