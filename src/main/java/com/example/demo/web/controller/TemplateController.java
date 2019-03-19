package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/TemplateController")
/**
 * @author LYW
 * 模板添加controller
 */
public class TemplateController {

    @RequestMapping("/view")
    public String toView() {
        return "/template/template";
    }
}
