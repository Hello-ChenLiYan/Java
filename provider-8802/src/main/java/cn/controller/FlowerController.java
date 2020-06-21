package cn.controller;

import cn.util.UploadUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.entity.Flower;
import cn.entity.common.CommonResult;
import cn.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("flower")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

    public final static String UPLOAD_PATH_PREFIX = "static/flowers/";

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

    @PostMapping("queryAllFlower")
    public List<Flower> queryAll(@RequestBody Flower bean){
        System.out.println("bean:::"+bean);
        return flowerService.queryAll(bean);
    }

    @PostMapping(value = "save")
    public Object save(@RequestBody Flower bean) {
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

    @PostMapping(value = "save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Object save(Integer id,
                       @RequestParam(value = "pictureFile",required = false) MultipartFile pictureFile) throws IOException {
        System.out.println("id+"+id);
        Flower bean = new Flower();
        bean.setId(id);
        System.out.println(bean);
        boolean result = false;
        UploadUtil uploadUtil = new UploadUtil();
        String picPath=null;
        String filePath = "consumer-8002/src/main/resources/" + UPLOAD_PATH_PREFIX;
        if(!pictureFile.isEmpty()){
            picPath = uploadUtil.uploadPhoto(pictureFile,filePath);
        }
        bean.setPhoto(picPath);
        result = flowerService.update(bean) > 0;
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