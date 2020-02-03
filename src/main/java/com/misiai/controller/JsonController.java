package com.misiai.controller;

import com.misiai.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JsonController {

    @ResponseBody
    @RequestMapping("/testJson")
    public User testJson() {
        System.out.println("helloJson");
        return new User("kuan", 12);
    }
}
