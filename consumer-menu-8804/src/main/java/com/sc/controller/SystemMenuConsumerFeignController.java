package com.sc.controller;


import com.sc.entity.SystemMenu;
import com.sc.service.SystemMenuFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("SystemMenu/feign")
public class SystemMenuConsumerFeignController {
  @Autowired
 private SystemMenuFeignService systemMenuFeignService;

    @RequestMapping("toList")
    public String toList() {
        return "menu/menu_list";
    }


    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, SystemMenu bean){
        System.out.println(bean);
        return systemMenuFeignService.queryAll(page,limit,bean);
    }

    @DeleteMapping("/{ids}")
    @ResponseBody
    public boolean delete(@PathVariable(value = "ids") Integer[] ids){
        System.out.println("#################");
        System.out.println(ids);
        return systemMenuFeignService.delete(ids);
    }



}
