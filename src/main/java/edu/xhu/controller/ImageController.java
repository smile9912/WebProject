package edu.xhu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class ImageController {


    @RequestMapping("/upload")
    public String fun(MultipartFile file) throws IOException {
        //貌似有BUG 万一照片的名字一样呢
        if(file != null) {
            //获取文件名
            String fileName = file.getOriginalFilename();
            //获取文件后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //设置文件路径
            String filePath = "D:/upload/";
            String path = filePath + fileName;
            File dest = new File(path);
            //检测是否存在该目录
            if(!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            //写入文件
            //path D:\ upload\ 登录注册背景图.png
            file.transferTo(dest);


            System.out.println("/product/" + fileName);
            return "/product/" + fileName;
        }
        return "";
    }
}
