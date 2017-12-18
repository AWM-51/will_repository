package com.wj.service;

import com.wj.dao.LoginLogDao;
import com.wj.dao.UserDao;
import com.wj.domain.LoginLog;
import com.wj.domain.User;
import com.wj.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    /*
    * 校验账号密码.
    * */
    public boolean hasMatchUser(String username,String password) throws Exception {
        MD5Util md5Util=new MD5Util();
        int matchedUserCount=userDao.getMatchCount(username,md5Util.md5Encode(password));
        return matchedUserCount>0;
    }
    /*
    * 通过username查找用户
    * */
     public User findUserByUsername(String username){
        return userDao.findUserByUserName(username);
     }

    /*
    * 登录成功后插入登录日志
    * */

    public void loginSuccess(User user) throws Exception {
         user.setCredits(5+user.getCredits());
         LoginLog loginLog=new LoginLog();
         loginLog.setUser_id(user.getUserId());
         loginLog.setIp(user.getLastIp());
         loginLog.setLogin_datetime(new Date());
         userDao.updateLoginInfo(user);
         loginLogDao.insertLoginLog(loginLog);
     }


}
