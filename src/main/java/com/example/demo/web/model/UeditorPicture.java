package com.example.demo.web.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 富文本图片保存路径
 * </p>
 *
 * @author Lyw
 * @since 2019-03-26
 */
@TableName("DP_NJ_UEDITOR_PICTURE")
public class UeditorPicture extends Model<UeditorPicture> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(
            value = "S_ID",
            type = IdType.INPUT
    )
    private String sId;
    /**
     * 图片名称
     */
    @TableField("S_PIC_NAME")
    private String sPicName;
    /**
     * 图片格式
     */
    @TableField("S_PIC_FORMAT")
    private String sPicFormat;
    /**
     * 发布者
     */
    @TableField("S_AUTHOR")
    private String sAuthor;
    /**
     * 图片路径
     */
    @TableField("S_PATH")
    private String sPath;
    /**
     * 插入日期
     */
    @TableField("D_INSERT")
    private Date dInsert;
    /**
     * 是否保存:1保存，其他未保存
     */
    @TableField("S_FLAG")
    private String sFlag;
    /**
     * 报表id
     */
    @TableField("S_REPORT_ID")
    private String sReportId;

    public UeditorPicture(){

    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsPicName() {
        return sPicName;
    }

    public void setsPicName(String sPicName) {
        this.sPicName = sPicName;
    }

    public String getsPicFormat() {
        return sPicFormat;
    }

    public void setsPicFormat(String sPicFormat) {
        this.sPicFormat = sPicFormat;
    }

    public String getsAuthor() {
        return sAuthor;
    }

    public void setsAuthor(String sAuthor) {
        this.sAuthor = sAuthor;
    }

    public String getsPath() {
        return sPath;
    }

    public void setsPath(String sPath) {
        this.sPath = sPath;
    }

    public Date getdInsert() {
        if (dInsert == null) {
            return null;
        }
        return (Date) dInsert.clone();
    }

    public void setdInsert(Date dInsert) {
        if (dInsert == null) {
            this.dInsert = null;
        }else {
            this.dInsert = (Date)dInsert.clone();
        }
    }

    public String getsFlag() {
        return sFlag;
    }

    public void setsFlag(String sFlag) {
        this.sFlag = sFlag;
    }

    public String getsReportId() {
        return sReportId;
    }

    public void setsReportId(String sReportId) {
        this.sReportId = sReportId;
    }

    @Override
    protected Serializable pkVal() {
        return this.sId;
    }

    @Override
    public String toString() {
        return "UeditorPicture{" +
                "sId=" + sId +
                ", sPicName=" + sPicName +
                ", sPicFormat=" + sPicFormat +
                ", sAuthor=" + sAuthor +
                ", sPath=" + sPath +
                ", dInsert=" + dInsert +
                ", sFlag=" + sFlag +
                ", sReportId=" + sReportId +
                "}";
    }
}
