package com.sc.controller;

import com.sc.entity.SystemMenu;
import com.sc.service.SystemMenuFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("SystemMenu/feign")
public class SystemMenuConsumerFeignController {

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
