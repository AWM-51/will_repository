package com.wj.dao;

import com.wj.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/*
* LoginLog Dao
* */
@Repository
public class LoginLogDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    private final static String INSERT_LOGIN_LOG_SQL="INSERT INTO login_log(user_id,ip,login_datetime) VALUE(?,?,?)";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public void insertLoginLog(LoginLog loginLog) {
        Object[] args={loginLog.getUser_id(),loginLog.getIp(),loginLog.getLogin_datetime()};
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL,args);
    }



}
