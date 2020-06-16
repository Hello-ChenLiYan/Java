package com.sc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sc.entity.Flower;
import com.sc.entity.common.CommonResult;
import com.sc.service.FlowerService;
import com.sc.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("flower")
public class FlowerController {

    public final static String UPLOAD_PATH_PREFIX = "static/uploadFile/";

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

//    @PostMapping(value = "save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        @PostMapping("save")
//    public Object save(@RequestBody Flower bean, MultipartFile pictureFile, HttpServletRequest request) throws IOException {
        public Object save(@RequestBody Flower bean) {
        System.out.println("bean:::"+bean);
        boolean result = false;
//        UploadUtil uploadUtil = new UploadUtil();
//        String picPath=null;
//        String filePath = new String("src/main/resources/"+ UPLOAD_PATH_PREFIX) +"flowers/";
        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
//            if(!pictureFile.isEmpty()){
//                picPath = request.getScheme()+"://"+ request.getServerName() + ":" + request.getServerPort() + uploadUtil.uploadPhoto(pictureFile,filePath);
//            }
//            bean.setPhoto(picPath);
            result = flowerService.update(bean) > 0;
        } else {
            //添加
//            if(!pictureFile.isEmpty()){
//                picPath =  request.getScheme()+"://"+ request.getServerName() + ":" + request.getServerPort() + uploadUtil.uploadPhoto(pictureFile,filePath);
//            }
//            bean.setPhoto(picPath);
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
