package com.example.demo.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.demo.web.model.JsTreeDemo;

import java.util.List;
import java.util.Map;

public interface IJsTreeDemoService extends IService<JsTreeDemo> {
    List<Map> treeList();
}
