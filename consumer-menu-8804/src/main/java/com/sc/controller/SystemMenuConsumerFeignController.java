package com.sc.controller;


import com.sc.entity.Admin;
import com.sc.entity.SystemMenu;
import com.sc.service.SystemMenuFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("systemMenu/feign")
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



    @GetMapping("/")
    public String toAdd(Model model) {
        model.addAttribute("bean", new SystemMenu());
        return "menu/menu_add";
    }

    @PostMapping("save")
    @ResponseBody
    public Object save(SystemMenu bean){
        System.out.println(bean);
        return systemMenuFeignService.save(bean);
    }

    @GetMapping("/{id}")
    public String toEdit(@PathVariable(value ="id")Integer id, Model model) {
        System.out.println("id:::" + id);
        SystemMenu bean = systemMenuFeignService.getById(id);
        model.addAttribute("bean", bean);
        return "menu/menu_add";
    }
}
