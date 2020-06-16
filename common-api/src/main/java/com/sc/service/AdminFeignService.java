package com.sc.service;


import com.sc.entity.Admin;
import com.sc.entity.AdminQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component //自动注入
@FeignClient(value = "provider-admin")//服务提供者
public interface AdminFeignService{


    @GetMapping("/admin/getById")
    Admin getById(@RequestParam("id")Integer id);

/*   @GetMapping("/admin/{id}")
    Object getById(@PathVariable(value = "id")Integer id);*/


    @PostMapping("admin/queryAll")
    Object queryAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @RequestBody AdminQuery bean);

    @PostMapping(value = "/admin/save")
    Object save(@SpringQueryMap Admin bean);

    @DeleteMapping("/admin/{ids}")
    boolean delete(@PathVariable(value = "ids") Integer[] ids);

}
