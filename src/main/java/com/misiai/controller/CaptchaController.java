package com.misiai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 验证码控制器测试
 */
@Controller
@RequestMapping("/captcha")
public class CaptchaController {

    @RequestMapping("/test")
    public String test(HttpSession session) {
        return "captcha";
    }

    @RequestMapping("/test2")
    public void test2(HttpSession session) {
        System.out.println(session.getAttribute("CAPTCHA"));
    }

}
