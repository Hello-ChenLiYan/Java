package com.sc.controller;

import com.sc.entity.Banji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 小胖
 */
@RestController
@RequestMapping("banji/consumer")
public class BanjiComsumerController {

    @Autowired
    private RestTemplate restTemplate;
    //提供一些便利的方法直接访问http请求

    private String urlPrefix = "http://provider-banji";

    @RequestMapping("insert")
    public ResponseEntity<Boolean> insert(Banji bean) {
        String uri = urlPrefix + "/banji/insert";
        return restTemplate.postForEntity(uri, bean, Boolean.class);
    }

    @RequestMapping("queryAll")
    public Object queryAll() {
        String uri = urlPrefix +  "/banji/queryAll";
        return restTemplate.getForObject(uri, List.class);
    }

    @RequestMapping("queryById/{id]")
    public Object queryById(@PathVariable Integer id) {
        String uri = urlPrefix +  "/banji/queryById" + id;
        return restTemplate.getForObject(uri, List.class);
    }

}
