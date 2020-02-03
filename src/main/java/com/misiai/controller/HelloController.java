package com.misiai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {


    // RequestMapping配置访问路径
    @RequestMapping("/test")
    public String hello() {
        System.out.println("Hello!");
        return null;
    }
}
