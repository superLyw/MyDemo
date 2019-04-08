package com.example.demo.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class CommonUtils {
    /**
     * 获取config配置文件参数方法
     * @param s  属性名
     * @return   属性值
     */
    public static String getConfigPro(String s){
        ResourceBundle resource = ResourceBundle.getBundle("config");
        String value = resource.getString(s);
        try {
            value =new String (value.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
