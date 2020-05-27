package com.xh.controller;

import com.xh.entity.User;
import com.xh.service.UserService;
import com.xh.util.ResultObjStr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-05-28 00:43:23
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private final UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/importExcel")
    public String importExcel (@RequestParam("file") MultipartFile file, Integer id) {
        try {
            return userService.importExcel(file, id).toJson();
        } catch (Exception e) {
            logger.error("上传excel后台错误 : " + e.getMessage());
            return new ResultObjStr(ResultObjStr.ERROR, "后台错误", null).toJson();
        }
    }

    @GetMapping(value = "/exportExcel", produces = "application/force-download;charset=utf-8")
    public String exportExcel (Integer id, String fileName, String excelFormat, HttpServletResponse response) {
        // 测试下载文件名为中文名
        // 设置下载框
        response.setContentType("application/force-download");
        try {
            fileName = fileName+"." + excelFormat;
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
            // response.addHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(fileName+"." + excelFormat, "UTF-8"));// 设置下载文件名（*+fileName这个值可以定死，下载时会引用这个名字如：”aa.xml“）
            // 处理火狐和Safari浏览器 中文文件名乱码
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"; filename*=utf-8''" + fileName);
            //拿到用户选择的路径
            OutputStream out = response.getOutputStream();
            this.userService.exportExcel(id, fileName, excelFormat, out);
        } catch (IOException e) {
            logger.error("下载excel后台错误 : " + e.getMessage());
        }
        return null;
    }
}