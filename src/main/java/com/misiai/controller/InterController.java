package com.misiai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试拦截之用
 */
@Controller
@RequestMapping("/inter")
public class InterController {

    @RequestMapping("/test")
    public String test() {
        System.out.println("/inter/test");
        return "success";
    }
}
