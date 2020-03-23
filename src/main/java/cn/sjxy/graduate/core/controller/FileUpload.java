package cn.sjxy.graduate.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * @Author: dpc
 * @Date: 2020/1/18 8:39
 * 文件上传
 */
@Controller
public class FileUpload {


    @GetMapping("/uploadFile")
    public String upload() {
        return "upload";
    }


    /**
     * 提取上传方法为公共方法
     *
     * @param uploadDir 上传文件目录
     * @param file      上传对象
     * @throws Exception
     */
    private void executeUpload(String uploadDir, MultipartFile file) throws Exception {
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        System.out.println("serverFile = " + serverFile);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }

    public String uploadDir(HttpServletRequest request) {
        String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return uploadDir;
    }

    /**
     * 上传文件方法
     *
     * @param file 前台上传的文件对象
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(HttpServletRequest request, MultipartFile file) {
        try {
            String uploadDir = uploadDir(request);
            //调用上传方法
            executeUpload(uploadDir, file);
        } catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    /**
     * 上传多个文件
     *
     * @param request 请求对象
     * @param file    上传文件集合
     * @return
     */
    @PostMapping("/uploads")
    @ResponseBody
    public String uploads(HttpServletRequest request, MultipartFile[] file) {
        try {
            //上传目录地址
            String uploadDir = uploadDir(request);
            //遍历文件数组执行上传
            for (int i = 1; i < file.length; i++) {
                if (file[i] != null) {
                    //调用上传方法
                    executeUpload(uploadDir, file[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }
}
