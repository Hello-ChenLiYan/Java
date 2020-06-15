package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
@RequestMapping("admin/consumer")
public class AdminConsuerControler {
   // @Autowired
    private RestTemplate restTemplate; //提供一些便利的方法直接访问http请求


    @RequestMapping("queryAll")
    public Object queryAll() {
        String uri = "http://localhost:8001/admin/queryAll";
        return restTemplate.getForObject(uri, List.class);
    }
}
