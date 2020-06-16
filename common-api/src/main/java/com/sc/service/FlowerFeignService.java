package com.sc.service;

import com.sc.config.FeignConfig;
import com.sc.entity.Flower;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Component
@FeignClient(value="provider-flower",configuration = FeignConfig.class)//服务名称
public interface FlowerFeignService {

    @GetMapping("/flower/getById")
    Flower getById(@RequestParam("id") Integer id);

    @PostMapping("/flower/queryAll")
    Object queryAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @RequestBody Flower bean);

    @PostMapping("/flower/save")
    Object save(@RequestBody Flower bean);
//    @PostMapping(value = "/flower/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)//@RequestParam("bean")
//    Object save(@SpringQueryMap Flower bean, @RequestPart("pictureFile")MultipartFile pictureFile, @RequestParam("request")HttpServletRequest request);

    @DeleteMapping("/flower/{ids}")
    boolean deleteById(@PathVariable(value = "ids") Integer[] ids);

}
