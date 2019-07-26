package com.example.demo.web.model;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

@TableName("SYS_USERS")
public class SysUser {
    @TableId("S_ID")
    private String sId;
    @TableField("S_NAME")
    private String sName;
    @TableField("S_EMAIL")
    private String sEmail;
    @TableField("S_PASSWORD")
    private String sPassword;
    @TableField("S_ISADMIN")
    private String sIsAdmin;
    @TableField("S_STATUS")
    private String sStatus;
    @TableField("D_UPDATETIME")
    private Date dUpdateTime;
    @TableField("D_CREATETIME")
    private Date dCreateTime;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsIsAdmin() {
        return sIsAdmin;
    }

    public void setsIsAdmin(String sIsAdmin) {
        this.sIsAdmin = sIsAdmin;
    }

    public String getsStatus() {
        return sStatus;
    }

    public void setsStatus(String sStatus) {
        this.sStatus = sStatus;
    }

    public Date getdUpdateTime() {
        return dUpdateTime;
    }

    public void setdUpdateTime(Date dUpdateTime) {
        this.dUpdateTime = dUpdateTime;
    }

    public Date getdCreateTime() {
        return dCreateTime;
    }

    public void setdCreateTime(Date dCreateTime) {
        this.dCreateTime = dCreateTime;
    }
}
