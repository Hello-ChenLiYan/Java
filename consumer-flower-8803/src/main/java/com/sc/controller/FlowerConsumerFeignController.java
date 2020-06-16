package com.sc.controller;

import com.sc.entity.Flower;
import com.sc.service.FlowerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yinrui
 */
@Controller
@RequestMapping("flower/feign")
public class FlowerConsumerFeignController {

    @Autowired
    private FlowerFeignService flowerFeignService;

    @RequestMapping("toList")
    public String toList() {
        return "flower/flower_list";
    }

    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page,Integer limit,Flower bean) {
        return flowerFeignService.queryAll(page, limit, bean);
    }

    @RequestMapping("toAdd")
    public String toAdd(Model model) {
        model.addAttribute("bean",new Flower());
        return "flower/flower_add";
    }

    @GetMapping("/{id}")
    public String toEdit(@PathVariable(value = "id") Integer id,Model model) {
        System.out.println("id:::" + id);
        Flower bean = flowerFeignService.getById(id);
        model.addAttribute("bean", bean);
        return "flower/flower_add";
    }

//    @PostMapping("save")
//    @ResponseBody
//    public Object save(Flower bean){
//        System.out.println(bean);
//        return flowerFeignService.save(bean);
//    }
    @PostMapping(value = "save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)//,consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}
    @ResponseBody
    public Object save(Flower bean,MultipartFile pictureFile){
        System.out.println(bean);
        if(!pictureFile.isEmpty() && bean.getId()!=null){
            return flowerFeignService.save(bean.getId(),pictureFile);
        }else {
            return flowerFeignService.save(bean);
        }
    }

    @DeleteMapping("/{ids}")
    @ResponseBody
    public boolean deleteById(@PathVariable(value = "ids") Integer[] ids){
        return flowerFeignService.deleteById(ids);
    }

}
