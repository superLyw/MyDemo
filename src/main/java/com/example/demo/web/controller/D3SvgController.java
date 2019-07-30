package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/d3Svg")
public class D3SvgController {
    @RequestMapping("/view")
    public String toView(){
        return "/d3Svg/d3Svg";
    }
}
