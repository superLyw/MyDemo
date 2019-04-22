package com.example.demo.web.service;


import java.util.List;
import java.util.Map;

public interface SysUserService {

    List<Map> queryList();

    List<Map> userLogin(String username,String password);
}
