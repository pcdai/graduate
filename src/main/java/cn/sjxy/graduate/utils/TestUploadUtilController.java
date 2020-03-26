package cn.sjxy.graduate.utils;

import cn.sjxy.graduate.entity.Restaurant;
import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.service.RestaurantService;
import cn.sjxy.graduate.service.ScenicService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/26 13:02
 */
@Controller
public class TestUploadUtilController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private ScenicService scenicService;

    @RequestMapping("/restaurant")
    @ResponseBody
    public String test(@RequestParam("name") MultipartFile file) {
        String upload = FileUtil.fileUpload(file);
        Restaurant restaurant = new Restaurant();
        upload = StringUtils.strip(upload.toString(), "[]");
        restaurant.setIcon(upload);
        restaurantService.save(restaurant);
        return upload;
    }

    @RequestMapping("/restaurantMore")
    @ResponseBody
    public String testMore(HttpServletRequest request) {
        List<String> list = FileUtil.filesUpload(request);
        String strip = StringUtils.strip(list.toString(), "[]");
        System.out.println("strip = " + strip);
        Restaurant restaurant = new Restaurant();
        restaurant.setImg(strip);
        restaurantService.save(restaurant);
        return "ok";
    }

    @RequestMapping("/scenic")
    @ResponseBody
    public String scenic(@RequestParam("name") MultipartFile file) {
        String url = FileUtil.fileUpload(file);
        Scenic scenic = new Scenic();
        scenic.setIcon(url);
        scenicService.save(scenic);
        return "ok";
    }
}
