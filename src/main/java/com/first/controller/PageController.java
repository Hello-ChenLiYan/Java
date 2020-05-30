package com.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 小胖
 */
@Controller
public class PageController {

    @GetMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

}
