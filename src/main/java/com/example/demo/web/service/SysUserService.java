package com.example.demo.web.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.web.model.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserService {

    List<Map> queryList();

    List<Map> userLogin(String username,String password);
}
