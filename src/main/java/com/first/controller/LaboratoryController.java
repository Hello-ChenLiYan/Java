package com.first.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.first.entity.Laboratory;
import com.first.entity.common.CommonResult;
import com.first.listener.LaboratoryExcelListener;
import com.first.service.LaboratoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;

/**
 * 实验室记录(Laboratory)表控制层
 *
 * @author makejava
 * @since 2020-06-07 22:10:20
 */
@Controller
@RequestMapping("laboratory")
public class LaboratoryController {
    /**
     * 服务对象
     */
    @Resource
    private LaboratoryService laboratoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Laboratory selectOne(Integer id) {
        return this.laboratoryService.queryById(id);
    }

    @RequestMapping("/toList")
    public String toLaboratoryList(){
        return "laboratory/laboratory_list";
    }

    @ResponseBody
    @PostMapping("/queryAll")
    public Object queryAll(Integer page, Integer limit, Laboratory bean) {

        CommonResult<Laboratory> result = new CommonResult<>();
        Integer offset = page*limit-limit;
        IPage<Laboratory> iPage = laboratoryService.queryAllByLimit(offset, limit, bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());

        return result;
    }

    @GetMapping("/")
    public String toAdd(Model model) {
        model.addAttribute("bean", new Laboratory());
        return "laboratory/laboratory_add";
    }

    @GetMapping("/{id}")
    public String toEdit(@PathVariable Integer id, Model model) {

        Laboratory bean = laboratoryService.queryById(id);

        model.addAttribute("bean", bean);
        return "laboratory/laboratory_add";
    }

    @PostMapping("/save")
    @ResponseBody
    public Object save(Laboratory bean) {

        boolean result = false;
        //判断账号是否存在
        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
            result = laboratoryService.update(bean);
        } else {
            //添加
            result = laboratoryService.insert(bean).getId() != null;
        }

        return result;
    }

    @DeleteMapping("/{ids}")
    @ResponseBody
    public boolean deleteById(@PathVariable Integer[] ids) {

        if (ids == null || ids.length == 0) {
            return false;
        }
        return laboratoryService.deleteById(Arrays.asList(ids));
    }

    /**
     * 文件上传
     * @param file 文件
     * @return 数据
     */
    @PostMapping("upload")
    @ResponseBody
    public Object upload(MultipartFile file) {
        CommonResult<String> result = new CommonResult<>();
        try {
            EasyExcel.read(file.getInputStream(), Laboratory.class, new LaboratoryExcelListener(laboratoryService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
            result.setMsg("Excel上传出错");
        }
        result.setData(file.getOriginalFilename());
        return result;
    }

}