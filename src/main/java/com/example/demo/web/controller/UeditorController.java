package com.example.demo.web.controller;


import com.baidu.ueditor.ActionEnter;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.example.demo.common.utils.CommonUtils;
import com.example.demo.web.model.PicInfo;
import com.example.demo.web.service.IPicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ueditor")
public class UeditorController{
    //图片路径
    private String GET_PIC_PATH = "/ueditor/getPic";

    private ResourceLoader resourceLoader;

    @Autowired
    private IPicInfoService iPicInfoService;
    @Autowired
    public UeditorController(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    public UeditorController() {
    }

    @RequestMapping("/view")
    public String index() {
        return "/richText/richText";
    }

    @RequestMapping("/config")
    @ResponseBody
    public String config(HttpServletRequest request) {
        String rootPath = "";
        return (new ActionEnter(request, rootPath)).exec();
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Object uploadFileWithDrag(MultipartRequest multipartRequest) {
        // 多文件上传实现
        MultipartFile file = null;
        Map<String, MultipartFile> map = multipartRequest.getFileMap();
        for (MultipartFile value : map.values()) {
            file = value;
        }
        HashMap<String, String> result = new HashMap<>();
        String realPath = CommonUtils.getConfigPro("picSaveLocal");
        File filePackage = new File(realPath + "\\");
        //判断当前目录是否存在
        if (!filePackage.exists()) {
            filePackage.mkdir();
        }
        //获取上传图片名称
        String fileName = file.getOriginalFilename();
        int lastIndex = fileName.lastIndexOf(".") - 1;
        //处理上传图片的名称
        String id = IdWorker.get32UUID();
        String targetName = id + fileName.substring(0, 1) + fileName.substring(lastIndex, fileName.length());
        File tragetFile = new File(filePackage, targetName);
        try {
            //存储指定目录
            file.transferTo(tragetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String picQueryLocal = GET_PIC_PATH + "?picid=" + targetName;
        PicInfo picInfo = new PicInfo();
        picInfo.setsId(id);
        picInfo.setsUrl(picQueryLocal);
        //存储访问图片路径的url、id到数据库
        boolean isInsert = iPicInfoService.insert(picInfo);

        result.put("original", fileName);
        result.put("title", fileName);
        //SUCCESS 一定要大写
        result.put("state", "SUCCESS");
        result.put("url", picQueryLocal);
        return result;
    }

//    图片回显
    @RequestMapping(value = "/getPic",produces="image/jpg",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getPic(@RequestParam("picid") String picid){
        String realPath = CommonUtils.getConfigPro("picSaveLocal") + "\\";
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(realPath, picid)));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
