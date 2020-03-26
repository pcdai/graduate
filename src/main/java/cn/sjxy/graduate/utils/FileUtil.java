package cn.sjxy.graduate.utils;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/26 12:52
 */
public class FileUtil {
    public static String fileUpload(MultipartFile file) {
        String url;
        if (file.isEmpty()) {
            return "上传文件不可为空";
        }
        String fileName = file.getOriginalFilename();
        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        String path = "D:/fileUpload/" + fileName;
        File dest = new File(path);
        if (dest.exists()) {
            return "文件已经存在";
        }
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            url = "http://localhost:8080/images/" + fileName;

        } catch (Exception e) {
            return "上传失败";
        }
        return url;
    }

    public static List<String> filesUpload(HttpServletRequest request) {
        String url;
        ArrayList<String> list = new ArrayList<>();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String path = "D:/fileUpload/";
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return null;
            }
            String fileName = file.getOriginalFilename();
            File dest = new File(path + fileName);
            try {
                file.transferTo(dest);
                url = "http://localhost:8080/images/" + fileName;
                list.add(url);
                System.out.println("上传第" + (i + 1) + "个文件成功");
            } catch (Exception e) {
                return null;
            }
        }
        System.out.println("list = " + list);
        return list;
    }
}
