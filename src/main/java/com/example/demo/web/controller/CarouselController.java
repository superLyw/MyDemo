package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Carousel")
/**
 * @author lyw
 */
public class CarouselController {
    @RequestMapping("/view")
    public String toView(){
        return "/carousel/carousel";
    }
}
