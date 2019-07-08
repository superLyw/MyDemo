package com.example.demo.web.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("TREE_INFO")
public class JsTreeDemo {
    @TableField("CODE_ID")
    private String sId;
    @TableField("CODE_TEXT")
    private String sText;
    @TableField("CODE_PID")
    private String sPid;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsText() {
        return sText;
    }

    public void setsText(String sText) {
        this.sText = sText;
    }

    public String getsPid() {
        return sPid;
    }

    public void setsPid(String sPid) {
        this.sPid = sPid;
    }
}
