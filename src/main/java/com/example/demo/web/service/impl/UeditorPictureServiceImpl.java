//package com.example.demo.web.service.impl;
//
//import com.baomidou.mybatisplus.service.impl.ServiceImpl;
//import com.example.demo.web.dao.UeditorPictureMapper;
//import com.example.demo.web.model.UeditorPicture;
//import com.example.demo.web.service.IUeditorPictureService;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartRequest;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
///**
// * <p>
// * 富文本图片保存路径 服务实现类
// * </p>
// *
// * @author HYF
// * @since 2019-03-05
// */
//@Service
//public class UeditorPictureServiceImpl extends ServiceImpl<UeditorPictureMapper, UeditorPicture> implements IUeditorPictureService {
//    @Resource
//    private UeditorPictureMapper ueditorPictureMapper;
//
//    /**
//     * 上传图片及保存图片信息
//     *
//     * @param multipartRequest 文件请求
//     * @param request          请求参数
//     * @param url              请求路径
//     * @return 图片信息
//     */
//    @Override
//    public Map<String, String> uploadFileWithDrag(MultipartRequest multipartRequest, HttpServletRequest request, String url) {
//        Map<String, String> result = new HashMap<>();
//
//        // 多文件上传实现
//        MultipartFile multipartFile = null;
//        Map<String, MultipartFile> map = multipartRequest.getFileMap();
//        for (MultipartFile value : map.values()) {
//            multipartFile = value;
//        }
//
//        if (null != multipartFile) {
//            String fileName = multipartFile.getOriginalFilename();
//            // 获取文件后缀
//            String suffix = fileName.substring(fileName.lastIndexOf("."));
//            // 随机生成上传目录中的文件名称
//            String id = UUID.randomUUID().toString().replace("-", "");
//
//            try {
//                // 上传路径及文件名
////                String fileSavePath = CommonUtil.getConfigPro("filePath") + "/editorPicture/";
//                String fileSavePath = "";
//                File file = new File(fileSavePath);
//                if (!file.exists()) {
//                    file.mkdirs();
//                }
//                multipartFile.transferTo(new File(fileSavePath + id + suffix));
//
//                // 附件信息写数据库
//                int nameLength = fileName.getBytes().length;
//                final int size = 100;
//                if (nameLength > size) {
//                    fileName = fileName.substring(0, 50);
//                }
//                UeditorPicture ueditorPicture = new UeditorPicture();
//                ueditorPicture.setsId(id);
//                ueditorPicture.setdInsert(new Date());
////                auUeditorPicture1.setsAuthor(ShiroKit.getUser().getName());
////                auUeditorPicture1.setsFlag("0");
//                ueditorPicture.setsPath(fileSavePath);
//                ueditorPicture.setsPicName(fileName);
//                ueditorPicture.setsPicFormat(suffix.replace(".", ""));
////                auUeditorPicture1.setsReportId();
//                ueditorPictureMapper.insert(ueditorPicture);
//
//                result.put("original", fileName);
//                result.put("title", fileName);
//                //SUCCESS 一定要大写
//                result.put("state", "SUCCESS");
//                result.put("url", url + "/showPicture?imageId=" + id);
//            } catch (IOException e) {
////                throw new HussarException(BizExceptionEnum.UPLOAD_ERROR);
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 显示图片
//     *
//     * @param response 响应
//     * @Title: showImage
//     * @author: WangBinBin
//     */
//    @Override
//    public void showImage(HttpServletRequest request, HttpServletResponse response) {
//        response.setContentType("text/html; charset=UTF-8");
//        response.setContentType("image/jpeg");
//        String id = request.getParameter("imageId");
//
//        UeditorPicture image = ueditorPictureMapper.selectById(id);
//
//        String fileName = image.getsPicName();
//        String fileId = image.getsId();
//        String fileSavePath = image.getsPath();
//        String suffix = fileName.substring(fileName.lastIndexOf("."));
//
//        String absolutePath = fileSavePath.replace("\\", "/") + "/" + fileId + suffix;
//        FileInputStream fis = null;
//        OutputStream os = null;
//        try {
//            fis = new FileInputStream(absolutePath);
//            os = response.getOutputStream();
//            byte[] byt = new byte[fis.available()];
//            fis.read(byt);
//            os.write(byt);
//            os.flush();
//        } catch (IOException e) {
////            throw new HussarException(com.jxdinfo.hussar.common.exception.BizExceptionEnum.DOWNLOAD_ERROR);
//        } finally {
//            try {
//                if (os != null) {
//                    os.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (fis != null) {
//                    fis.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//}
