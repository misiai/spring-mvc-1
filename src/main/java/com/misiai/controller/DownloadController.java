package com.misiai.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/download")
public class DownloadController {


    @RequestMapping("/")
    public void down(String name, HttpSession session, HttpServletResponse response) {

        System.out.println("name = " + name);
        String path = session.getServletContext().getRealPath(("/upload"));
        String real_path = path + File.separator + name;

        //设置响应头
        response.setHeader("Content-type", "attachment;filename=" + name);

        // 读取目标文件，输出给浏览器
        try {
            IOUtils.copy(new FileInputStream(real_path), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
