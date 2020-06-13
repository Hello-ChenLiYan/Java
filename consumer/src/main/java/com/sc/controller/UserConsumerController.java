package com.sc.controller;

import com.sc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * * @author 小胖
 */
@RestController
@RequestMapping("user/consumer")
public class UserConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    //提供一些便利的方法直接访问http请求

    private String urlPrefix = "http://provider-user";

    @RequestMapping("insert")
    public ResponseEntity<Boolean> insert(User bean) {
        String uri = urlPrefix + "/user/insert";
        return restTemplate.postForEntity(uri, bean, Boolean.class);
    }

    @RequestMapping("queryAll")
    public Object queryAll() {
        String uri = urlPrefix +  "/user/queryAll";
        return restTemplate.getForObject(uri, List.class);
    }

    @RequestMapping("queryById/{id}")
    public Object queryById(@PathVariable Integer id) {
        String uri = urlPrefix +  "/user/queryById" + id;
        return restTemplate.getForObject(uri, List.class);
    }

    @RequestMapping("deleteById/{id}")
    public void deleteById(@PathVariable Integer id){
        String uri = urlPrefix + "/user/deleteById" + id;
        restTemplate.delete(uri);
    }

    @RequestMapping("updateById")
    public ResponseEntity<User> updateById(@PathVariable Integer id,User bean){
        String uri = urlPrefix + "/user/save" + id;
        return restTemplate.postForEntity(uri,bean,User.class);
    }
}
