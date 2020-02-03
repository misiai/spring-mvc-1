package com.misiai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lang")
public class LangController {
    @RequestMapping("/test")
    public String test() {
        return "lang";
    }
}
