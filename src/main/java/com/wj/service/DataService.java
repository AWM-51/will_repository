package com.wj.service;

import com.wj.dao.SampleDataDao;
import com.wj.dao.UploadSDExcelLogDao;
import com.wj.domain.SampleData;
import com.wj.domain.UploadSDExcelLog;
import com.wj.domain.User;
import com.wj.util.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class DataService {
    @Autowired
    private SampleDataDao sampleDataDao;
    @Autowired
    private UploadSDExcelLogDao uploadSDExcelLogDao;


    /*
    * 上传成功excel
    * */
    @Transactional
    public int uploadExcelSuccess(MultipartFile file, User user) throws IOException, ParseException {
        ReadExcel readExcel=new ReadExcel();

        String fileName=file.getOriginalFilename();//获取文件名
        System.out.println("@@@"+file.getOriginalFilename()+"!!!"+fileName);
        int uploadUserId=user.getUserId();//获取上传者的ID
        Date entyrTime=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                .parse(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                        .format(new Date()));//数据样本录入时间
        List<SampleData> sampleData = readExcel.readXls(file,entyrTime);
        int datanum= sampleData.size();//样本数据数量
        for(SampleData sd : sampleData){
            sampleDataDao.insertSampleData(sd);//插入数据至数据库
        }
        do_ExcelUpload_Log(entyrTime,uploadUserId,fileName,datanum);


        return 1;
    }

    /*
    * 录入文件的日志
    *
    * */

    public void do_ExcelUpload_Log(Date uploadTime,int uploadUserId
            ,String excelName,int dataNum){
        String remark="";
        UploadSDExcelLog uploadSDExcelLog=new UploadSDExcelLog();
        uploadSDExcelLog.setExcel_name(excelName);
        uploadSDExcelLog.setData_num(dataNum);
        uploadSDExcelLog.setUpload_time(uploadTime);
        uploadSDExcelLog.setUpload_user_id(uploadUserId);
        uploadSDExcelLog.setRemarks(remark);

        uploadSDExcelLogDao.insertUploadSDExcel(uploadSDExcelLog);

    }
}
