package com.wj.service;

import com.wj.dao.SampleDataDao;
import com.wj.domain.SampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Repository
public class DataService {
    @Autowired
    private SampleDataDao sampleDataDao;

    /*
    * 上传成功excel
    * */
    @Transactional
    public int uploadExcelSuccess(MultipartFile file) throws IOException, ParseException {
        ReadExcel readExcel=new ReadExcel();
        List<SampleData> sampleData = readExcel.readXls(file);
        for(SampleData sd : sampleData){
            sampleDataDao.insertSampleData(sd);
        }
        return 1;
    }
}
