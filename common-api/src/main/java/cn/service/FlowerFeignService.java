package cn.service;

import cn.entity.Flower;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Component
@FeignClient(value = "provider")//服务提供者
public interface FlowerFeignService {

    @GetMapping("/flower/getById")
    Flower getById(@RequestParam("id") Integer id);

    @PostMapping("/flower/queryAll")
    Object queryAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @RequestBody Flower bean);

    @PostMapping("/flower/queryAllFlower")
    Object queryAll(@RequestBody Flower bean);

    @PostMapping("/flower/queryByKey")
    List<Flower> queryByKeys(@RequestParam("key") String key);

    @PostMapping("/flower/save")
    Object save(@RequestBody Flower bean);

    @PostMapping(value = "/flower/save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Object save(@RequestParam("id") Integer id, @RequestPart("pictureFile") MultipartFile pictureFile);

    @DeleteMapping("/flower/{ids}")
    boolean deleteById(@PathVariable(value = "ids") Integer[] ids);

}
