package com.example.demo.web.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.web.dao.SysUserMapper;
import com.example.demo.web.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<Map> queryList(Page page){
        return sysUserMapper.queryList(page);
    }
    @Override
    public List<Map> userLogin(String username,String password){
        return sysUserMapper.userLogin(username,password);
    }
}
