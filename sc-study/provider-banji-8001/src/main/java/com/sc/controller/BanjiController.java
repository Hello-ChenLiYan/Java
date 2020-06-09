package com.sc.controller;


import com.sc.entity.Banji;
import com.sc.service.BanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("banji")
public class BanjiController {
    @Autowired
    private BanjiService banjiService;

    @PostMapping("insert")
    public Object insert(Banji bean) {
        return banjiService.insert(bean);
    }

    @GetMapping("queryAll")
    public Object queryAll() {
        return banjiService.queryAll();
    }
}
