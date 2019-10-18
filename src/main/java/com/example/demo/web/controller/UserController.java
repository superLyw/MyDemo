//package com.example.demo.web.controller;
//
//import com.example.demo.common.utils.ProtoBufUtil;
//import com.example.demo.web.model.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.Date;
//
//@Controller
//@RequestMapping("/user")
//public class UserController {
//
//    @RequestMapping("/test")
//    public void test() {
//
//        User user = new User();
//        user.setUserId(1);
//        user.setUserTypeId(1);
//        user.setUserName("XRQ");
//        user.setCreateDateTime(new Date());
////序列化成ProtoBuf数据结构
//        byte[] userProtoObj = ProtoBufUtil.serializer(user);
//
////ProtoBuf数据结构反序列化成User对象
//        User newUserObj = ProtoBufUtil.deserializer(userProtoObj, User.class);
//        System.out.println(newUserObj);
//
//    }
//}
