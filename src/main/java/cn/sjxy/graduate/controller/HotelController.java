package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Activity;
import cn.sjxy.graduate.entity.Hotel;
import cn.sjxy.graduate.entity.News;
import cn.sjxy.graduate.entity.Restaurant;
import cn.sjxy.graduate.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * (Hotel)表控制层
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@Controller
@RequestMapping("hotel")
public class HotelController {
    /**
     * 服务对象
     */

    @Autowired
    @Resource
    private RestaurantService restaurantService;
    private MemberService memberService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private ActivityService activityService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("hotelDetails")
    public String hotelDetails(Integer id, Model model) {
        Hotel hotel = hotelService.findById(id);
        if (hotel != null && !StringUtils.isEmpty(hotel.getImg())) {
            hotel.setImgList(Arrays.asList(hotel.getImg().split(",")));
        }
        model.addAttribute("hotel", hotel);
        return "hotel_detail";
    }

    @GetMapping("hotelList")
    public String hotelList(@RequestParam(name = "pn", defaultValue = "1", required = false) Integer pn
            , @RequestParam(name = "ps", defaultValue = "2", required = false) Integer ps, Model model) {
        PageHelper.startPage(pn, ps);
        List<Hotel> list = hotelService.findAll();
        PageInfo<Hotel> info = new PageInfo<>(list, 4);
        System.out.println("info = " + info);
        /**
         * 下面代码是屎
         */
        /**
         * 美食
         */
        List<Restaurant> restList = restaurantService.selectHotLimit();
        model.addAttribute("restList", restList);
        /**
         * 新闻
         */

        List<News> newsList = newsService.findAll();
        model.addAttribute("newsList", newsList);
        /**
         * 活动
         */
        List<Activity> activityList = activityService.findAll();
        model.addAttribute("activityList", activityList);
        /**
         * 民宿
         */
        List<Hotel> hotelList = hotelService.findAll();
        model.addAttribute("hotelList", hotelList);

        model.addAttribute("info", info);
        return "hotel_list";
    }
}