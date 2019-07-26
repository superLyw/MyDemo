package com.example.demo.web.service;


import com.baomidou.mybatisplus.service.IService;
import com.example.demo.web.model.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserService extends IService<SysUser> {

    List<Map> queryList();

    List<Map> userLogin(String username, String password);

    Object addUser(String username, String password);
}
