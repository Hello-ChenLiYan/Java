package com.xh.poi.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xiaohe
 */
public class ExcelUtil {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    public static void main(String[] args) throws Exception {
        InputStream inp = new FileInputStream("C:\\Users\\小胖\\Desktop\\17外包第6学期实训安排(4).xlsx");
        List<List<Object>> excels = readExcel(inp);
        if (excels == null) {
            System.exit(0);
        }
        for (List<Object> rows : excels) {
            for (Object cell : rows) {
                System.out.println(cell.getClass().getName());
                System.out.println(cell);
            }
            System.out.println("===");
        }
    }

    /**
     * 解析excel
     *
     * @param inp excel InputStream.
     *
     * @return 对应数据列表
     */
    public static List<List<Object>> readExcel(InputStream inp) {
        Workbook wb = null;
        try {
            // 用这种方法创建Workbook可以同时兼容xls、xlsx两种格式
            wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();
            List<List<Object>> excels = new ArrayList<>();
            for (Row row : sheet) {
                List<Object> excelRows = new ArrayList<>();
                for (Cell cell : row) {

                    String text = formatter.formatCellValue(cell);
                    // System.out.println(text)
                    excelRows.add(text);

                }
                excels.add(excelRows);
            }
            return excels;
        } catch (Exception e) {
            logger.error("导入excel错误 : " + e.getMessage());
            return null;
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
                if (inp != null) {
                    inp.close();
                }
            } catch (Exception e) {
                logger.error("导入excel关流错误 : " + e.getMessage());
            }
        }


    }

    /**
     * excelFormat >> xls 、 xlsx default:excelFormat
     *
     * @param excels      数据
     * @param sheetName   单元格名称
     * @param excelFormat Excel 格式
     * @param fileOut     输出流
     */
    public static void exportExcel(List<List<Object>> excels, String sheetName, String excelFormat,
                                   OutputStream fileOut) {
        Workbook wb = null;
        try {
            // 去除不允许的字符
            sheetName = WorkbookUtil.createSafeSheetName(sheetName);
            System.out.println(sheetName);
            switch (excelFormat) {
                case "xls":
                    wb = new HSSFWorkbook();
                    break;
                case "xlsx":
                    wb = new XSSFWorkbook();
                    break;
                default:
                    wb = new XSSFWorkbook();
                    break;
            }

            // CreationHelper createHelper = wb.getCreationHelper()
            Sheet sheet = wb.createSheet();

            // 使用字体
            // 创建一个新的字体并设定对应样式
            Font font = wb.createFont();
            font.setFontHeightInPoints((short) 16);
            font.setFontName("宋体");
//			font.setItalic(true);
//			font.setStrikeout(true);
            // 字体被设置为一种风格，因此创建一个新的使用
            CellStyle style = wb.createCellStyle();
            style.setFont(font);

            for (int i = 0; i < excels.size(); i++) {
                Row row = sheet.createRow(i);
                for (int j = 0; j < excels.get(i).size(); j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue((String) excels.get(i).get(j));
                    cell.setCellStyle(style);
                }
            }
            wb.write(fileOut);
        } catch (Exception e) {
            logger.error("导出excel util错误 : " + e.getMessage());
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
                if (fileOut != null) {
                    fileOut.close();
                }
            } catch (IOException e) {
                logger.error("导出excel关流错误 : " + e.getMessage());
            }
        }

    }

}
