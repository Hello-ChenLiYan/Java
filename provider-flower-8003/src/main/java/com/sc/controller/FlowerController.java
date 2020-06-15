package com.sc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Flower;
import com.sc.entity.common.CommonResult;
import com.sc.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("flower")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

    @GetMapping("getById")
    public Object getById(Integer id){
        return this.flowerService.queryById(id);
    }

    @PostMapping("queryAll")
    public Object queryAll(Integer page, Integer limit, @RequestBody Flower bean){
        System.out.println("bean:::"+bean);
        CommonResult<Flower> result = new CommonResult<>();
        IPage<Flower> iPage = flowerService.queryAllByLimit(page, limit, bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }

    @PostMapping("save")
    public Object save(@RequestBody Flower bean) {
        System.out.println("bean:::"+bean);
        boolean result = false;
        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
            result = flowerService.update(bean) > 0;
        } else {
            //添加
            result = flowerService.insert(bean).getId() != null;
        }

        return result;
    }

    @DeleteMapping("/{ids}")
    public boolean deleteById(@PathVariable Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
        flowerService.deleteById(Arrays.asList(ids));
        return true;
    }

}
