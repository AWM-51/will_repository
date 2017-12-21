package com.wj.domain;

import javax.xml.crypto.Data;
import java.util.Date;

public class UploadSDExcelLog {
    private int uploadSDExcel_log_id;
    private Date upload_time;
    private int upload_user_id;
    private String excel_name;
    private int data_num;
    private String remarks;

    public int getUploadSDExcel_log_id() {
        return uploadSDExcel_log_id;
    }

    public void setUploadSDExcel_log_id(int uploadSDExcel_log_id) {
        this.uploadSDExcel_log_id = uploadSDExcel_log_id;
    }

    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }

    public Date getUpload_time() {
        return upload_time;
    }

    public void setUpload_user_id(int upload_user_id) {
        this.upload_user_id = upload_user_id;
    }

    public int getUpload_user_id() {
        return upload_user_id;
    }

    public void setExcel_name(String excel_name) {
        this.excel_name = excel_name;
    }

    public String getExcel_name() {
        return excel_name;
    }

    public void setData_num(int data_num) {
        this.data_num = data_num;
    }

    public int getData_num() {
        return data_num;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }
}
