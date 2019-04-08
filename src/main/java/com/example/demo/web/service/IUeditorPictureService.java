//package com.example.demo.web.service;
//
//import com.baomidou.mybatisplus.service.IService;
//import com.example.demo.web.model.UeditorPicture;
//import org.springframework.web.multipart.MultipartRequest;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Map;
//
///**
// * <p>
// * 富文本图片保存路径 服务类
// * </p>
// *
// * @author HYF
// * @since 2019-03-05
// */
//public interface IUeditorPictureService extends IService<UeditorPicture> {
//    /**
//     * 上传图片及保存图片信息
//     *
//     * @param multipartRequest 文件请求
//     * @param request          请求参数
//     * @param url              请求路径
//     * @return 图片信息
//     */
//    Map<String, String> uploadFileWithDrag(MultipartRequest multipartRequest, HttpServletRequest request, String url);
//
//    /**
//     * 显示图片
//     *
//     * @param request  请求
//     * @param response 响应
//     */
//    void showImage(HttpServletRequest request, HttpServletResponse response);
//}
