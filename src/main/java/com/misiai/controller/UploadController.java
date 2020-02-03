package com.misiai.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {
    @RequestMapping("/test")
    public String test(MultipartFile source, HttpSession session) {
        /*细节：
         * 变量名source必须和表单中的name属性值一样。
         * */
        // 原始名称
        String originalFilename = source.getOriginalFilename();
        // 定义全局唯一名（伪）：
        String unique = UUID.randomUUID().toString();
        // 文件后缀
        String extension = FilenameUtils.getExtension(originalFilename);
        // 全局文件名：
        String uniqueFileName = unique + "." + extension;
        System.out.println("uniqueFileName = " + uniqueFileName);

        // 文件类型：
        String contentType = source.getContentType();
        System.out.println("contentType = " + contentType);

        // 获得磁盘,在webapp目录下有一个upload目录，且初始不要为空，不然编译时要背忽略
        String real_path = session.getServletContext().getRealPath("/upload");
        System.out.println("real_path = " + real_path);

        //上传文件，存入磁盘中
        try {
            source.transferTo(new File(real_path + "\\" + uniqueFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }
}
