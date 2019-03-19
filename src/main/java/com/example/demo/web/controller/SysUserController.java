package com.example.demo.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.common.utils.BaseController;
import com.example.demo.web.service.SysUserService;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {
    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/view")
    public String view(){
        return "/sysUser/sysUser";
    }

    @RequestMapping("/queryList")
    @ResponseBody
    public Object queryList(@RequestParam(value = "pageSize", defaultValue = "15") String pageSize,     //页码大小
                            @RequestParam(value = "pageNumber", defaultValue = "1") String pageNumber){
        Page page = new Page(Integer.parseInt(pageNumber), Integer.parseInt(pageSize));
        List<Map> list = sysUserService.queryList(page);
        HashMap map = new HashMap();
        map.put("rows",list);
        map.put("total",list.size());
        return map;
    }
    @RequestMapping("register")
    public void register(@RequestParam(value = "username", defaultValue = "") String username,
                         @RequestParam(value = "password",defaultValue = "") String password){


    }
    @RequestMapping("userLogin")
    public void userLogin(@RequestParam(value = "username", defaultValue = "") String username,
                         @RequestParam(value = "password",defaultValue = "") String password){
        List<Map> list = sysUserService.userLogin(username,password);

    }
}
