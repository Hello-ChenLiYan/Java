package com.first.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.first.entity.Laboratory;
import com.first.service.LaboratoryService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 小胖
 */
public class LaboratoryExcelListener extends AnalysisEventListener<Laboratory> {

    private LaboratoryService laboratoryService;

    private Laboratory laboratory;

   private List<Laboratory> data = new ArrayList<>();

    public LaboratoryExcelListener(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @Override
    public void invoke(Laboratory laboratory, AnalysisContext analysisContext) {
        data.add(laboratory);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //当Excel解析完毕后，执行
        if ( laboratoryService != null) {
            laboratoryService.insert(laboratory);
        }
    }
}
