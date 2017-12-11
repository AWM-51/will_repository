package com.wj.dao;


import com.wj.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;

import java.sql.ResultSet;
import java.sql.SQLException;
/*
* User Dao
* */
@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;
    private static final String MATCH_COUNT_SQL="select count(*) from user where userName = ? and password = ?";
    private static final String UPDATE_LOGIN_INFO_SQL=" update user set lastVisit=?,lastIp=?,credits=? where user_id= ? ";
    private static final String SELECT_USER_BY_USERNAME_SQL="select * from user where userName=?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public  int getMatchCount(String userName,String password)
    {
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL,Integer.class,new Object[]{userName,password});
    }
    public User findUserByUserName(final String userName){

        final User user =new User();
        jdbcTemplate.query(SELECT_USER_BY_USERNAME_SQL, new Object[]{ userName },
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
                        user.setUserId(resultSet.getInt("user_id"));
                        user.setUserName(userName);
                        user.setCredits(resultSet.getInt("credits"));
                        user.setPassword(resultSet.getString("password"));

                    }
                });
        return user;
    }
    public void updateLoginInfo(User user){
         jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId());
    }



}
