package com.wj.dao;

import com.wj.domain.SampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDataDao {
    private JdbcTemplate jdbcTemplate;
    private static String INSERT_SAMPLE_DATA_SQL=" INSERT INTO sample_Data(sample_date,entry_date,sample_data_one" +
            " ,sample_data_two,sample_data_three,sample_data_four,sample_data_five) VALUE(?,?,?,?,?,?,?) ";
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}

    public void insertSampleData(SampleData sampleData){
        Object[] arg={sampleData.getSampling_time()
                ,sampleData.getEntry_Time(),sampleData.getSampleData_one(),sampleData.getSampleData_two()
                ,sampleData.getSampleData_three(),sampleData.getSampleData_four(),sampleData.getSampleData_five()};
         jdbcTemplate.update(INSERT_SAMPLE_DATA_SQL,arg);
    }


}
