package com.sc.controller;

import com.sc.service.FlowerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flower/feign")
public class FlowerConsumerFeignController {
    @Autowired
    private FlowerFeignService flowerFeignService;



}
