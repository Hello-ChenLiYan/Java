package com.sc.controller;


import com.sc.entity.Admin;
import com.sc.entity.AdminQuery;
import com.sc.service.AdminFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("admin/feign")
public class AdminConsumerFeignController {
    @Autowired
   private AdminFeignService adminFeignService;

    @RequestMapping("toList")
    public String toList() {
        return "user/admin_list";
    }


    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit,AdminQuery bean){
        System.out.println(bean);
        return adminFeignService.queryAll(page,limit,bean);
    }

    @RequestMapping("toAdd")
    public String toAdd(Model model) {
        model.addAttribute("bean",new Admin());
        return "user/admin_add";
    }

    @GetMapping("/{id}")
    public String toEdit(@PathVariable(value = "id")Integer id,Model model) {
        System.out.println("id:::" + id);
        Admin bean = adminFeignService.getById(id);
        System.out.println("consumer"+bean);
        model.addAttribute("bean", bean);
        return "user/admin_add";
    }

    @PostMapping("save")
    @ResponseBody
    public Object save(Admin bean){
        System.out.println(bean);
        return adminFeignService.save(bean);
    }

    @DeleteMapping("/{ids}")
    @ResponseBody
    public boolean delete(@PathVariable(value = "ids") Integer[] ids){
        System.out.println("#################");
        System.out.println(ids);
        return adminFeignService.delete(ids);
    }


}
