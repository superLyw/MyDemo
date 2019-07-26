package com.example.demo.web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.web.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysUserMapper extends BaseMapper<SysUser> {
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
