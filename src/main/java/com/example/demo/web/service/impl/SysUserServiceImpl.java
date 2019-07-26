package com.example.demo.web.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.common.utils.ResultUtil;
import com.example.demo.web.dao.SysUserMapper;
import com.example.demo.web.model.SysUser;
import com.example.demo.web.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<Map> queryList() {
        return sysUserMapper.queryList();
    }

    @Override
    public List<Map> userLogin(String username, String password) {
        return sysUserMapper.userLogin(username, password);
    }

    @Override
    public Object addUser(String username, String password) {
        List<SysUser> isFlag = selectList(new EntityWrapper<SysUser>().eq("S_ID", username));
        if (isFlag.size() > 0) {
            return ResultUtil.error(200, "用户名已存在");
        }
        SysUser sysUser = new SysUser();
        sysUser.setsId(username);
        sysUser.setsPassword(password);
        sysUser.setdCreateTime(new Date());
        sysUser.setdUpdateTime(new Date());
        sysUser.setsStatus("1");
        this.insert(sysUser);
        return ResultUtil.success();
    }
}
