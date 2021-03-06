package com.wj.service;

import com.wj.dao.SampleDataDao;
import com.wj.dao.UploadSDExcelLogDao;
import com.wj.domain.SampleData;
import com.wj.domain.UploadSDExcelLog;
import com.wj.domain.User;
import com.wj.util.ReadExcel;
import com.wj.util.SampleDataHandler;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;



@Repository
public class DataService {
    @Autowired
    private SampleDataDao sampleDataDao;
    @Autowired
    private UploadSDExcelLogDao uploadSDExcelLogDao;


    /*
    * 上传成功excel,并记录日志
    *
    * */
    @Transactional
    public int uploadExcelSuccess(MultipartFile file, User user) throws IOException, ParseException {
        if(file.isEmpty()){
            return 0;
        }

        ReadExcel readExcel=new ReadExcel();
        SampleDataHandler sampleDataHandler = new SampleDataHandler();
        UploadSDExcelLog uploadSDExcelLog=new UploadSDExcelLog();

        String fileName=file.getOriginalFilename();//获取文件名
        System.out.println("获得文件："+file.getOriginalFilename());

        int uploadUserId=user.getUserId();//获取上传者的ID

        Date entyrTime=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                .parse(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                        .format(new Date()));//数据样本录入时间

        try{
            List<SampleData> sampleDatas = readExcel.readXls(file,entyrTime);//读入表格
            int datanum= sampleDatas.size();//样本数据数量
            do_ExcelUpload_Log(entyrTime,uploadUserId,fileName,datanum);//将上传日志相关信息传入数据库
            uploadSDExcelLog=sampleDataDao.selectUploadExcelID(entyrTime);//目的是从数据库中将与entryTime相同的日志取出，使用他的id

            for(SampleData sd : sampleDatas){

                sd.setAverage_value(sampleDataHandler.get_stanardData(sampleDataHandler.get_average(sd)));//在SampleData插入数据库前就将平均值算出。
                sd.setVariance(sampleDataHandler.get_stanardData(sampleDataHandler.get_variance(sd)));//在SampleData插入数据库前就将方差算出。
                sd.setStandard_Deviation(sampleDataHandler.get_stanardData(sampleDataHandler.get_standard_Deviation(sd)));//在SampleData插入数据库前就将标准差算出。

                sampleDataDao.insertSampleData(sd,uploadSDExcelLog.getUploadSDExcel_log_id());//插入数据至数据库
            }
        }catch (NullPointerException ex){
            System.out.println(ex);

        }




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
