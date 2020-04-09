package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.*;
import cn.sjxy.graduate.service.*;
import cn.sjxy.graduate.utils.FileUtil;
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
public class FileUploadUtilController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private ScenicService scenicService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private StrategyService strategyService;

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
        Restaurant restaurant = new Restaurant();
        restaurant.setImg(strip);
        restaurantService.save(restaurant);
        return "ok";
    }

    @RequestMapping("/scenicFile")
    @ResponseBody
    public String scenic(@RequestParam("name") MultipartFile file) {
        String url = FileUtil.fileUpload(file);
        Scenic scenic = new Scenic();
        scenic.setIcon(url);
        scenicService.save(scenic);
        return "ok";
    }

    @RequestMapping("/scenicMore")
    @ResponseBody
    public String testMore2(HttpServletRequest request) {
        List<String> list = FileUtil.filesUpload(request);
        String strip = StringUtils.strip(list.toString(), "[]");
        Scenic scenic = new Scenic();
        scenic.setImg(strip);
        scenicService.save(scenic);
        return "ok";

    }

    @RequestMapping("/memberFile")
    @ResponseBody
    public String member(@RequestParam("name") MultipartFile file) {
        String url = FileUtil.fileUpload(file);
        Member member = new Member();
        member.setPhoto(url);
        memberService.save(member);
        return "ok";
    }

    @Autowired
    private NewsService newsService;

    @RequestMapping("/newsFile")
    @ResponseBody
    public String newsFile(@RequestParam("name") MultipartFile file) {
        String upload = FileUtil.fileUpload(file);
        News news = new News();
        news.setIcon(upload);
        newsService.save(news);
        return "ok";
    }

    @RequestMapping("newsList")
    @ResponseBody
    public String newsList(HttpServletRequest request) {
        List<String> list = FileUtil.filesUpload(request);
        System.out.println("list = " + list);
        String strip = StringUtils.strip(list.toString(), "[]");
        News news = new News();
        news.setImg(strip);
        newsService.save(news);
        return "ok";
    }

    @RequestMapping("/hotelFile")
    @ResponseBody
    public String hotelFile(@RequestParam("name") MultipartFile file) {
        String upload = FileUtil.fileUpload(file);
        Hotel hotel = new Hotel();
        hotel.setIcon(upload);
        hotelService.save(hotel);
        return "ok";
    }

    @RequestMapping("hotelList")
    @ResponseBody
    public String hotelList(HttpServletRequest request) {
        List<String> list = FileUtil.filesUpload(request);
        System.out.println("list = " + list);
        String strip = StringUtils.strip(list.toString(), "[]");
        Hotel hotel = new Hotel();
        hotel.setImg(strip);
        hotelService.save(hotel);
        return "ok";
    }


    @RequestMapping("/strategy")
    @ResponseBody
    public String strategy(@RequestParam("name") MultipartFile file) {
        String upload = FileUtil.fileUpload(file);
        Strategy strategy = new Strategy();
        strategy.setIcon(upload);
        strategyService.save(strategy);
        return "ok";
    }

    @RequestMapping("strategyList")
    @ResponseBody
    public String strategyList(HttpServletRequest request) {
        List<String> list = FileUtil.filesUpload(request);
        String strip = StringUtils.strip(list.toString(), "[]");
        Strategy strategy = new Strategy();
        strategy.setImg(strip);
        strategyService.save(strategy);
        return "ok";
    }

}
