package com.example.demo.controller;

import com.example.demo.Serve.UploadServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UploaController {
    @Autowired
    private UploadServe uploadServe;

    /**
     * 文件上传的具体实现
     *
     * @param multipartFile
     * @param request
     * @return
     */
    @PostMapping("/upload/file")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        if (multipartFile.isEmpty()) {
            return "文件为空";
        }
//        1.获取用户指定的文件夹问这个文件夹为什么要从页面上传递过来呢
//做隔离不同业务不同文件放在不同目录中
        String dir = request.getParameter("dir");
        return uploadServe.Uploadimg(multipartFile,dir);
    }
}
