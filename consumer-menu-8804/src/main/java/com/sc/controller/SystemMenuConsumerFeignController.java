package com.sc.controller;


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




    @Autowired
    private SystemMenuFeignService systemMenuFeignService;

    @GetMapping("/")
    public String toAdd(Model model) {
        model.addAttribute("bean", new SystemMenu());
        return "menu/menu_add";
    }

    @GetMapping("/{id}")
    public String toEdit(@PathVariable Integer id, Model model) {
        System.out.println("id:::" + id);
        SystemMenu bean = systemMenuFeignService.queryById(id);
        model.addAttribute("bean", bean);

        return "menu/menu_add";
    }
}
