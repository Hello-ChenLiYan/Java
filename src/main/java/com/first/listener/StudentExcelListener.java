package com.first.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.first.entity.Student;
import com.first.service.StudentService;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 小胖
 */
public class StudentExcelListener extends AnalysisEventListener<Student> {
    private List<Student> data = new ArrayList<>();

    private StudentService studentService;

    public StudentExcelListener(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void invoke(Student studentExcel, AnalysisContext analysisContext) {
        //解析数据保存到studentExcel
        data.add(studentExcel);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //当Excel解析完毕后，执行
        System.out.println(data);
        if (studentService != null) {
            studentService.insert(data);
        }
    }
}
