package com.sc.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtil {
    /**
     * 上传文件并存储
     * @param picture 图片文件
     * @param filePath 项目路径
     * @return
     */
    public String uploadPhoto(MultipartFile picture,String filePath) throws IOException {
        if(!picture.isEmpty()){
            String imgName = UUID.randomUUID().toString().replace("-","");
            //获取原始文件名并截取图片后缀名
            String fileName = picture.getOriginalFilename();
            String imaLastName = fileName.substring(fileName.lastIndexOf("."));
            //创建本地文件流，存放图片路径
            File oldfile = new File(filePath);
            File file = new File(oldfile.getAbsolutePath()+imgName+imaLastName);
            //写入磁盘
            picture.transferTo(file);
            String picPath = "/flowers/"+imgName+imaLastName;
            return picPath;
        }
        return null;
    }
}
