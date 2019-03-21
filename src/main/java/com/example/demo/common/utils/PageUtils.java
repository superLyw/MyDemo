package com.example.demo.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 分页工具类
 * @author Lyw
 * @since 2019-3-20
 */
public class PageUtils {
    /**
     *
     * @param pageNumber 页码
     * @param pageSize 每页条数
     * @param list 查询数据
     * @return  HashMap
     */
    public static HashMap pageListSql(int pageNumber, int pageSize, List list){
        HashMap result = new HashMap();
        ArrayList data = new ArrayList();
        int start = (pageNumber-1) * pageSize;
        int end = start + pageSize;
        if(list != null && list.size() > 0){
            for (int i = 0, l = list.size(); i < l; i++) {
                if (start <= i && i < end) {
                    data.add(list.get(i));
                }
            }
            result.put("total", list.size());
        }else{
            result.put("total", 0);
        }
        result.put("rows", data);
        return result;
    }
}
