package com.sc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Flower;
import com.sc.entity.common.CommonResult;
import com.sc.service.FlowerService;
import com.sc.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("flower")
public class FlowerController {

    public final static String UPLOAD_PATH_PREFIX = "static/flowers/";

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

    @PostMapping(value = "save")
    public Object save(@RequestBody Flower bean) throws IOException {
//        public Object save(@RequestBody Flower bean) {
        System.out.println("bean+"+bean);
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

//        @PostMapping("save")
    @PostMapping(value = "save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Object save(Integer id,
                       @RequestParam(value = "pictureFile",required = false) MultipartFile pictureFile) throws IOException {
//        public Object save(@RequestBody Flower bean) {
        System.out.println("id+"+id);
        Flower bean = new Flower();
        bean.setId(id);
        System.out.println(bean);
        boolean result = false;
        UploadUtil uploadUtil = new UploadUtil();
        String picPath=null;
        String filePath = "consumer-flower-8803/src/main/resources/" + UPLOAD_PATH_PREFIX;
        //编辑
        if(!pictureFile.isEmpty()){
            picPath = uploadUtil.uploadPhoto(pictureFile,filePath);
        }
        bean.setPhoto(picPath);
        result = flowerService.update(bean) > 0;
        return result;
    }

    @DeleteMapping("/{ids}")
    public boolean deleteById(@PathVariable("ids") Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
        flowerService.deleteById(Arrays.asList(ids));
        return true;
    }

}
