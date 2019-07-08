package com.example.demo.web.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.common.utils.Result;
import com.example.demo.common.utils.ResultUtil;
import com.example.demo.web.model.JsTreeDemo;
import com.example.demo.web.service.IJsTreeDemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.UUID;

@Controller
@RequestMapping("/jsTreeDemo")
public class JsTreeDemoController {

    @Resource
    private IJsTreeDemoService iJsTreeDemoService;

    @RequestMapping("/view")
    public String view() {
        return "/jsTreeDemo/jsTreeDemo";
    }

    @RequestMapping("/treeList")
    @ResponseBody
    public Object treeList() {
        return iJsTreeDemoService.treeList();
    }

    @RequestMapping("/addTree")
    @ResponseBody
    public Result addTree(JsTreeDemo jsTreeDemo) {
        if ("".equals(jsTreeDemo.getsId())) {
            jsTreeDemo.setsId(UUID.randomUUID().toString().replace("-", ""));
            iJsTreeDemoService.insert(jsTreeDemo);
        } else {
            iJsTreeDemoService.update(jsTreeDemo, new EntityWrapper<JsTreeDemo>().eq("CODE_ID", jsTreeDemo.getsId()));
        }
        return ResultUtil.success();
    }
    @RequestMapping("/delTree")
    @ResponseBody
    public Result delTree(@RequestParam("sId")String sId) {
        iJsTreeDemoService.delete(new EntityWrapper<JsTreeDemo>().eq("CODE_ID",sId));
        return ResultUtil.success();
    }
}
