package com.wj.domain;
/*
* User
* */
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
    private int userId;
    private String userName;
    private String password;
    private int credits;
    private String lastIp;
    private Date lastVisit;

    public void setUserId(int userId){
        this.userId=userId;
    }
    public int getUserId(){
        return userId;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getUserName() {
        return userName;
    }

    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword() {
        return password;
    }

    public void setCredits(int credits){
        this.credits=credits;
    }
    public int getCredits()
    {
        return credits;
    }

    public void setLastIp(String lastIp){
        this.lastIp=lastIp;
    }
    public String getLastIp(){
        return lastIp;
    }

    public void setLastVisit(Date lastVisit){ this.lastVisit=lastVisit; }
    public Date getLastVisit() {
        return lastVisit;
    }
}