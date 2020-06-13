package com.sc.controller;

import com.sc.entity.User;
import com.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


/**
 * 用户管理表(User)表控制层
 *
 * @author makejava
 * @since 2020-06-12 17:42:52
 */
@RestController
@RequestMapping("user")
public class UserProviderController {

    @Autowired
    private UserService userService;

    @PostMapping("insert")
    public Object insert(User bean) {
        return userService.insert(bean);
    }

    @GetMapping("queryAll")
    public Object queryAll(User bean) {
        return userService.queryAll( bean);
    }

    @GetMapping("queryById/{id}")
    //@HystrixCommand(fallbackMethod = "getDefaultUser") //服务降级即回调一个方法
    public Object queryById(@PathVariable  Integer id){
        User user = userService.queryById(id);
        if(user == null){
            throw new RuntimeException("出错啦，没有该指定id"); //服务熔断
        }
        return user;
    }

    private Object getDefaultUser(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        user.setAccount("无账号");
        return user;
    }

    @PostMapping("save")
    @ResponseBody
    public Object save(User bean) {

        boolean result = false;
        //判断账号是否存在
        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
            result = userService.update(bean);
        } else {
            //添加
            result = userService.insert(bean).getId() != null;
        }

        return result;
    }

    @DeleteMapping("deleteById/{ids}")
    @ResponseBody
    public boolean deleteById(@PathVariable Integer[] ids) {

        if (ids == null || ids.length == 0) {
            return false;
        }
        return userService.deleteById(Arrays.asList(ids));
    }
}