package com.example.demo.web.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {
    /**
     * 查询所有用户
     * @return
     */
    List<Map> queryList();

    /**
     * 判断用户是否存在
     */
    List<Map> userLogin(@Param("username")String username,
                        @Param("password")String password);
}
