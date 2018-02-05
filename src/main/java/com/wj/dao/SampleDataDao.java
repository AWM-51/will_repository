package com.wj.dao;

import com.wj.domain.LoginLog;
import com.wj.domain.SampleData;
import com.wj.domain.UploadSDExcelLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class SampleDataDao {
    private JdbcTemplate jdbcTemplate;
    private static String INSERT_SAMPLE_DATA_SQL=" INSERT INTO sample_Data(sample_date,entry_date,sample_data_one" +
            " ,sample_data_two,sample_data_three,sample_data_four,sample_data_five,uploadSDExcel_log_id,average_value,variance,standard_Deviation) VALUE(?,?,?,?,?,?,?,?,?,?,?) ";
    private static String SELECT_UPLOADEXCEL_LOG_SQL="SELECT * from uploadSDExcel_log where upload_time = ?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}

    public void insertSampleData(SampleData sampleData,int upload_log_id){
        Object[] arg={sampleData.getSampling_time()
                ,sampleData.getEntry_Time(),sampleData.getSampleData_one(),sampleData.getSampleData_two()
                ,sampleData.getSampleData_three(),sampleData.getSampleData_four(),sampleData.getSampleData_five(),upload_log_id
                ,sampleData.getAverage_value(),sampleData.getVariance(),sampleData.getStandard_Deviation()};
         jdbcTemplate.update(INSERT_SAMPLE_DATA_SQL,arg);
    }

    public UploadSDExcelLog selectUploadExcelID(Date data){
        final UploadSDExcelLog uploadSDExcelLog= new UploadSDExcelLog();
        jdbcTemplate.query(SELECT_UPLOADEXCEL_LOG_SQL,new Object[]{data}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                uploadSDExcelLog.setUploadSDExcel_log_id(resultSet.getInt("uploadSDExcel_log_id"));
                uploadSDExcelLog.setUpload_user_id(resultSet.getInt("upload_user_id"));
                uploadSDExcelLog.setData_num(resultSet.getInt("data_num"));
                uploadSDExcelLog.setExcel_name(resultSet.getString("excel_name"));
            }
        });
        return uploadSDExcelLog;
    }


}
