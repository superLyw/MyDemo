package com.example.demo.web.controller;


import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/ueditor"})
public class UeditorController{
    public UeditorController() {
    }

    @RequestMapping({"/view"})
    public String index() {
        return "/richText/richText";
    }

    @RequestMapping({"/config"})
    @ResponseBody
    public String config(HttpServletRequest request) {
        String rootPath = "";
        return (new ActionEnter(request, rootPath)).exec();
    }
}
