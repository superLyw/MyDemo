package com.example.demo.web.controller;

import io.netty.util.internal.StringUtil;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;


@Controller
public class IndexController {
    @RequestMapping("/")
    public String getIndex(HttpSession session) {
        Object username = session.getAttribute("username");
        System.out.println("11111111111111111111");
        if(org.springframework.util.StringUtils.isEmpty(username)){
            return "/login";
        }
        return "/index";
    }
    @RequestMapping("/error1")
    public String getError(){
        return "/error";
    }
}
