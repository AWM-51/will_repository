package com.wj.util;

import com.wj.domain.SampleData;

import java.io.IOException;
import java.io.InputStream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;


public class ReadExcel {
    /*
    读取.xls表格
    读取 抽检时间，样本1，2，3，4，5
    录入时间自动生成 格式如 2017-01-02
    如果某行有空值，则该行无效（后期优化成空值设为0）
    * */
    public List<SampleData> readXls(MultipartFile file,Date entryTime) throws IOException, ParseException,NullPointerException {
        InputStream is = file.getInputStream();
        XSSFWorkbook XSSFWorkbook = new XSSFWorkbook(is);
        SampleData SampleData = null;
        List<SampleData> list = new ArrayList<SampleData>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < XSSFWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet XSSFSheet = XSSFWorkbook.getSheetAt(numSheet);
            if (XSSFSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= XSSFSheet.getLastRowNum(); rowNum++) {
                XSSFRow XSSFRow = XSSFSheet.getRow(rowNum);
                if (XSSFRow != null) {
                    SampleData = new SampleData();
//                    List<XSSFCell> CellList = new ArrayList<XSSFCell>();
//                    for(int i = 1;i<7;++i){
//                        if (XSSFRow.getCell(i).toString().isEmpty()){
//                            XSSFRow.getCell(i).setCellValue(0);
//                        }
//                        CellList.add(XSSFRow.getCell(i));
//                    }
//                    XSSFCell sample_time = CellList.get(1);
//                    XSSFCell SampleData_one = CellList.get(2);
//                    XSSFCell SampleData_two = CellList.get(3);
//                    XSSFCell SampleData_three = CellList.get(4);
//                    XSSFCell SampleData_four = CellList.get(5);
//                    XSSFCell SampleData_five = CellList.get(6);

                    try {
                        XSSFCell sample_time = XSSFRow.getCell(1);
                        XSSFCell SampleData_one = XSSFRow.getCell(2);
                        XSSFCell SampleData_two = XSSFRow.getCell(3);
                        XSSFCell SampleData_three = XSSFRow.getCell(4);
                        XSSFCell SampleData_four = XSSFRow.getCell(5);
                        XSSFCell SampleData_five = XSSFRow.getCell(6);
                        SampleData.setSampling_time(sample_time.getDateCellValue());
                        SampleData.setEntry_Time(entryTime);
                        SampleData.setSampleData_one(Double.valueOf(getValue(SampleData_one)));
                        SampleData.setSampleData_two(Double.valueOf(getValue(SampleData_two)));
                        SampleData.setSampleData_three(Double.valueOf(getValue(SampleData_three)));
                        SampleData.setSampleData_four(Double.valueOf(getValue(SampleData_four)));
                        SampleData.setSampleData_five(Double.valueOf(getValue(SampleData_five)));
                        list.add(SampleData);
                    }catch (NullPointerException ex){
                        System.out.println(ex);
                        continue;
                    }


                }
            }
        }
        return list;
    }

    @SuppressWarnings("static-access")
    private String getValue(XSSFCell XSSFCell) {
//        if (XSSFCell == null) {
//            return null;
//        }
        if (XSSFCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(XSSFCell.getBooleanCellValue());
        } else if (XSSFCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(XSSFCell.getNumericCellValue());
        }
        else {
            // 返回字符串类型的值
            return String.valueOf(XSSFCell.getStringCellValue());
        }
    }
}
