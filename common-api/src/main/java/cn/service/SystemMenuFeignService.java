package cn.service;

import cn.entity.SystemMenu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Component
@FeignClient(value = "provider")//服务提供者
public interface SystemMenuFeignService {

    @GetMapping("/systemMenu/getById")
    SystemMenu getById(@RequestParam("id") Integer id);


    @PostMapping("systemMenu/queryAll")
    Object queryAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @SpringQueryMap SystemMenu bean);


    @PostMapping("systemMenu/save")
    Object save(@SpringQueryMap SystemMenu bean);

    @DeleteMapping("/systemMenu/{ids}")
    boolean delete(@PathVariable(value = "ids") Integer[] ids);

    @GetMapping("systemMenu/menus")
    Map<String,Object> menus();
}
