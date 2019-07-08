package com.example.demo.web.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.web.dao.IJsTreeDemoMapper;
import com.example.demo.web.model.JsTreeDemo;
import com.example.demo.web.service.IJsTreeDemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class JsTreeDemoServiceImpl extends ServiceImpl<IJsTreeDemoMapper,JsTreeDemo> implements IJsTreeDemoService {
    @Resource
    private IJsTreeDemoMapper iJsTreeDemoMapper;
    @Override
    public List<Map> treeList(){
        return iJsTreeDemoMapper.treeList();
    }
}
