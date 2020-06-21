package cn.controller;

import cn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
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

    private String urlPrefix = "http://provider";

    //登录
    @RequestMapping("login")
    public String login(String account, String password, HttpSession session, Model model, HttpCookie cookie) {

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("account", account);
        map.add("password", password);
        // 进行请求，并返回数据
        restTemplate.postForObject(urlPrefix + "/user/login", map, String.class);
        if (map.isEmpty()) {
            model.addAttribute("msg", "账号或密码错误");
            return "login";
        }
        session.setAttribute("loginUser", account);


        System.out.println("account:::" + account + "，password:::" + password);
        return "index";
    }

    //注册
    @RequestMapping("register")
    public String register(User bean, String cfmPassword, Model model) {

        bean = restTemplate.postForObject(urlPrefix + "/user/insert", bean, User.class);
        System.out.println(bean);
        if (bean == null) {
            model.addAttribute("msg", "注册失败");
            return "register";
        }
        //判断用户名是否重复
        if (bean.getAccount() != null) {
            model.addAttribute("msg", "该账号已被使用！");
            return "register";
        }
        //判断两次密码是否一致
        if (!bean.getPassword().equals(cfmPassword)) {
            model.addAttribute("msg", "两次输入密码不一致");
            return "register";
        }
        return "login";
    }

    //退出登录
    @RequestMapping("loginOut")
    public String loginOut() {
        return "login";
    }

    //插入
    @RequestMapping("insert")
    public String insert(User bean,Model model) {
        String uri = urlPrefix + "/user/insert";
        restTemplate.postForEntity(uri, bean, User.class);
        model.addAttribute("bean", bean);
        return "user/user_add";
    }

    @RequestMapping("queryAll")
    @ResponseBody
    public Object queryAll() {
        String uri = urlPrefix + "/user/queryAll";
        return restTemplate.getForObject(uri, List.class);
    }

    @RequestMapping("queryById/{id}")
    public Object queryById(@PathVariable Integer id) {
        String uri = urlPrefix + "/user/queryById/" + id;
        return restTemplate.getForObject(uri, User.class);
    }

    @RequestMapping("deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        String uri = urlPrefix + "/user/deleteById/" + id;
        restTemplate.delete(uri);
    }

    @RequestMapping("updateById/{id}")
    public ResponseEntity<User> updateById(@PathVariable Integer id, User bean) {
        String uri = urlPrefix + "/user/save/" + id;
        return restTemplate.postForEntity(uri, bean, User.class);
    }

    @RequestMapping("delete/{ids}")
    public void delete(@PathVariable Integer[] ids) {
        String uri = urlPrefix + "/user/deleteById/" + ids;
        System.out.println(ids);
        restTemplate.delete(uri);
    }

    @RequestMapping("toList")
    public String toList() {
        return "user/user_list";
    }

}
