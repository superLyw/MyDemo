package com.example.demo.web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.web.model.JsTreeDemo;

import java.util.List;
import java.util.Map;

public interface IJsTreeDemoMapper extends BaseMapper<JsTreeDemo> {
    List<Map> treeList();
}
