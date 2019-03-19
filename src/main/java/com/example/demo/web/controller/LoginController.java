package com.example.demo.web.controller;

import com.example.demo.common.utils.Result;
import com.example.demo.common.utils.ResultUtil;
import com.example.demo.web.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RequestMapping("/login")
@Controller
public class LoginController {

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/view")
    public String getLogin() {
        return "/login";
    }

    @RequestMapping("/isUser")
    @ResponseBody
    public Result isUser(HttpServletRequest request,HttpSession session){
        //测试使用
        String username = "qqqq";
        String password = "123";
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        List<Map> list = sysUserService.userLogin(username,password);

        if(list.size()>0){
            session.setAttribute("username",username);
            session.setAttribute("password",password);
        }else{
            return ResultUtil.error(200,"账号密码不匹配");
        }

        return ResultUtil.success();
    }

    @RequestMapping("/getSessionUser")
    @ResponseBody
    public String getSessionUser(HttpSession session){
        return session.getAttribute("username").toString();
    }

    @RequestMapping("/register")
    public void register(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

    }
}
