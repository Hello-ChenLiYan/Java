package cn.controller;


import cn.entity.SystemMenu;
import cn.service.SystemMenuFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("SystemMenu/feign")
public class SystemMenuConsumerFeignController {
  @Autowired
 private SystemMenuFeignService systemMenuFeignService;

    @RequestMapping("toList")
    public String toList() {
        return "menu/menu_list";
    }

    @GetMapping("menus")
    @ResponseBody
    public Map<String,Object> menus(){
        return systemMenuFeignService.menus();
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

    @GetMapping("/{id}")
    public String toEdit(@PathVariable Integer id, Model model) {
        System.out.println("id:::" + id);
        SystemMenu bean = systemMenuFeignService.getById(id);
        model.addAttribute("bean", bean);
        return "menu/menu_add";
    }

}
