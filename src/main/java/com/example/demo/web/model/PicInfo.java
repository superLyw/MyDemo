package com.example.demo.web.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 图片信息实体类
 */
@TableName("YW_PIC_INFO")
public class PicInfo {
    @TableId("S_ID")
    private String sId;
    @TableField("S_URL")
    private String sUrl;


    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl;
    }
}
