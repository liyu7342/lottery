package com.fr.lottery.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.xssf.usermodel.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by Lthui on 2017/4/5.
 */
public class ExcelUtil extends DefaultHandler {
    /*
    * 导出错数据
    * */
    @SuppressWarnings("unchecked")
    public static void exportJsonToExcel(String fileName, Map<String, String> configColMap, JSONArray jsonArray, HttpServletResponse response) {
        try {
            XSSFWorkbook wb = getSheets(configColMap, jsonArray, "");
            response.setContentType("application/vnd.ms-excel");
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx;");
            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * 生成错误数据Excel
    * */
    public static void createExcelFile(Map<String, String> configColMap, JSONArray jsonArray, String saveFilePath, String dataType) {
        XSSFWorkbook wb = getSheets(configColMap, jsonArray, dataType);
        try {
            FileOutputStream fileOut = new FileOutputStream(saveFilePath);
            wb.write(fileOut);
            fileOut.close();
            wb.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static XSSFWorkbook getSheets(Map<String, String> configColMap, JSONArray jsonArray, String dataType) {
        // 新建文件
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("询价导出");
        XSSFRow row = sheet.createRow((int) 0);
        XSSFCellStyle style = wb.createCellStyle();
        sheet.setDefaultColumnWidth(10);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        int ih = 0;
        for (Map.Entry<String, String> key : configColMap.entrySet()) {
            XSSFCell cell = row.createCell(ih);
            cell.setCellValue(key.getValue());
            cell.setCellStyle(style);
            //sheet.autoSizeColumn(ih);
            ih++;
        }
        int column = 0; // 列数计数
        // 遍历jsonArray
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject item = jsonArray.getJSONObject(i); // 得到数组的每项
            row = sheet.createRow(i + 1);
            column = 0;// 从第0列开始放
            for (Map.Entry<String, String> key : configColMap.entrySet()) {
                try {
                    String value = item.getString(key.getKey()); // 得到key对应的value
                    row.createCell(column).setCellValue(value);
                } catch (Exception ex) {
                    String exceptionValue = "";
                    row.createCell(column).setCellValue(exceptionValue);
                }
                column++;
            }
        }
        return wb;
    }
}

