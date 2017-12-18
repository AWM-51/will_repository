package com.wj.dao;

import com.wj.domain.UploadSDExcelLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UploadSDExcelLogDao {
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}
    private JdbcTemplate jdbcTemplate=new JdbcTemplate();
    private static String INSERT_UPLOADSDEXCEL_SQL="INSERT INTO uploadSDExcel_log " +
            " (upload_time,upload_user_id,excel_name,data_num,remarks) " +
            " VALUE(?,?,?,?,?)";

    public void insertUploadSDExcel(UploadSDExcelLog uploadSDExcelLog){
        Object[] arg={uploadSDExcelLog.getUpload_time(),uploadSDExcelLog.getUpload_user_id()
                ,uploadSDExcelLog.getExcel_name(),uploadSDExcelLog.getData_num(),uploadSDExcelLog.getRemarks()};
        jdbcTemplate.update(INSERT_UPLOADSDEXCEL_SQL,arg);
    }



}
