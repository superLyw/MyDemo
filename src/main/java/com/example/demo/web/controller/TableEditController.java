package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tableEdit")
public class TableEditController {
    @RequestMapping("/view")
    public String toView() {
        return "/tableEdit/tableEdit";
    }
}
