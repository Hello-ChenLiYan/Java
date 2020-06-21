package cn.controller;

import cn.entity.Flower;
import cn.service.FlowerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author
 */
@Controller
@RequestMapping("flower/feign")
public class FlowerConsumerFeignController {

    @Autowired
    private FlowerFeignService flowerFeignService;

    @RequestMapping("/detailFlower/{id}")
    public String getById(@PathVariable Integer id, HttpSession session){
        Flower bean = flowerFeignService.getById(id);
        session.setAttribute("flower",bean);
        return "flower/flowersDetails";
    }

    @RequestMapping("queryAllFlower")
    public String queryAll(String name,Flower bean,Model model){
        if(name!=null){
            bean.setName(name);
        }
        List<Flower> list = (List<Flower>) flowerFeignService.queryAll(bean);
        model.addAttribute("flowerList",list);
        return "flower/flowerShop_list";
    }

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

    @PostMapping(value = "save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //,consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}
    @ResponseBody
    public Object save(Flower bean, MultipartFile pictureFile){
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

