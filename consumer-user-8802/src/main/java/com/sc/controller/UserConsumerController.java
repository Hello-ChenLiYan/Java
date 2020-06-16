package com.sc.controller;

import com.sc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * * @author 小胖
 */
@Controller
@RequestMapping("user/consumer")
public class UserConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    //提供一些便利的方法直接访问http请求

    private String urlPrefix = "http://provider-user";

    //登录
    @RequestMapping("login")
    public String login(String account,String password, HttpSession session, Model model){

        User bean = new User();
        MultiValueMap<String,Object> map = new LinkedMultiValueMap<>();
        map.add("account",account);
        map.add("password",password);
        // 进行请求，并返回数据
        restTemplate.postForObject(urlPrefix + "/user/login", map, String.class);
        if (map.isEmpty()) {
            model.addAttribute("msg", "账号或密码错误");
            return "login";
        }
        session.setAttribute("loginUser",account);
        System.out.println("account:::" + account + "，password:::"+password);
        return "index";
    }

    //退出登录
    @RequestMapping("loginOut")
    public String loginOut(){
        return "login";
    }

    //插入
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
        String uri = urlPrefix +  "/user/queryById/" + id;
        return restTemplate.getForObject(uri, User.class);
    }

    @RequestMapping("deleteById/{id}")
    public void deleteById(@PathVariable Integer id){
        String uri = urlPrefix + "/user/deleteById/" + id;
        restTemplate.delete(uri);
    }

    @RequestMapping("updateById/{id}")
    public ResponseEntity<User> updateById(@PathVariable Integer id,User bean){
        String uri = urlPrefix + "/user/save/" + id;
        return restTemplate.postForEntity(uri,bean,User.class);
    }
}
