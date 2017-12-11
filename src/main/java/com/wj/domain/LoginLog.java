package com.wj.domain;
/*
* LoginLog
* */
import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {
    private int loginLogId;
    private int user_id;
    private String ip;
    private Date login_datetime;

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }
    public int getLoginLogId() {
        return loginLogId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getIp() {
        return ip;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getUser_id() {
        return user_id;
    }

    public void setLogin_datetime(Date login_datetime) {
        this.login_datetime = login_datetime;
    }

    public Date getLogin_datetime() {
        return login_datetime;
    }
}
