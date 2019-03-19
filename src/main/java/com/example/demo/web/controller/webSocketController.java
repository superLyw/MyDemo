package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webSocket")
public class webSocketController {
    @RequestMapping("/view")
    public String view(){
        return "/websocket/webSocket";
    }
}
