package com.misiai.controller;

import com.misiai.exception.LoginException;
import com.misiai.exception.PermissionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 以下两个test，用来测试权限问题
     */
    @RequestMapping("/test01")
    public void test01() {
        if (1 == 1) {
            throw new LoginException("无法登录");
        }else{
            System.out.println("登录成功");
        }
    }

    @RequestMapping("/test02")
    public void test02() {
        if (1 == 1) {
            throw new PermissionException("权限不足");
        }else{
            System.out.println("您拥有权限");
        }
    }


    /**
     * 登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        System.out.println("登录");
        return "login";
    }

    /**
     * 权限不足页面
     */
    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    public String permission() {
        System.out.println("权限不足页面");
        return "permission";
    }

    /**
     * 全局异常页面
     */
    @RequestMapping(value = "/global_err", method = RequestMethod.GET)
    public String global_err() {
        System.out.println("全局异常页面");
        return "global_err";
    }
}
