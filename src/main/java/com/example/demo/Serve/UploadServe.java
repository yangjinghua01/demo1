package com.example.demo.Serve;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class UploadServe {
    /**
     *
     * @param multipartFile
     * 是springMVC提供的文件上传接受的一个类
     * 他的底层会自动会和httpservlet request中的request.getinputstream进行融合
     * 从而达到文件上传的目的
     * @param dir
     * @return
     */
    public String Uploadimg(MultipartFile multipartFile,String dir){
//        指定文件上传的目录
        if (dir == null){
            dir ="yjh";
        }
        try {
            String realFilename = multipartFile.getOriginalFilename();
            //            截取文件名的后缀
            String imgStrBuffer = realFilename.substring(realFilename.lastIndexOf("."));
//            生成唯一文件名
            String newfilename = UUID.randomUUID().toString()+imgStrBuffer;
//            日期目录
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
            String datapath = dateFormat.format(new Date());
//            最终目录指定文件上传的目录
            File targetPath =new File("D://webtest/"+dir,datapath);
//
            if (!targetPath.exists())targetPath.mkdirs();
//            文件上传服务器的完整文件名
            File targerFilename = new File(targetPath,newfilename);
//            文件上传到指定目录
            multipartFile.transferTo(targerFilename);
            return dir+"/"+datapath+"/"+newfilename;
        } catch (IOException e) {
            e.printStackTrace();
            return "no";
        }
    }

}
