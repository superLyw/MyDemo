package com.example.demo.web.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.web.dao.IPicInfoMapper;
import com.example.demo.web.model.PicInfo;
import com.example.demo.web.service.IPicInfoService;
import org.springframework.stereotype.Service;

@Service
public class PicInfoServiceImpl extends ServiceImpl<IPicInfoMapper,PicInfo> implements IPicInfoService{
}
