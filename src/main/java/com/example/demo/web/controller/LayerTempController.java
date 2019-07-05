package com.example.demo.web.controller;

import com.example.demo.web.service.ILayerTempService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/layerTemp")
public class LayerTempController {
    @Resource
    private ILayerTempService iLayerTempService;

    @RequestMapping("/view")
    public String view(){
        return "/layerTemp/layerTemp";
    }
}
