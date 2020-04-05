package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Activity;
import cn.sjxy.graduate.entity.News;
import cn.sjxy.graduate.entity.Restaurant;
import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.service.ActivityService;
import cn.sjxy.graduate.service.NewsService;
import cn.sjxy.graduate.service.RestaurantService;
import cn.sjxy.graduate.service.ScenicService;
import cn.sjxy.graduate.utils.ConditionUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Condition;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/26 9:16
 */
@Controller

public class IndexController {
    @Autowired
    private ScenicService scenicService;

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private ActivityService activityService;

    @RequestMapping("/index")
    public String initIndex(HttpSession session, Model model) {
        /**
         * 热门景点，做轮播
         */
        List<Scenic> scenics = scenicService.queryAllHotScenicLimitFour();
        model.addAttribute("scenics", scenics);
        /**
         * 景区 首页展示
         */
        List<Scenic> scenics2 = scenicService.queryForScenic();
        model.addAttribute("scenics2", scenics2);
        /**
         * 休闲 首页展示
         */
        /**
         * 热点新闻
         */
        List<News> five = newsService.findLimitFive();

        model.addAttribute("newsList", five);
        List<Scenic> scenics1 = scenicService.queryForRelax();
        model.addAttribute("scenics1", scenics1);
        /**
         * 活动
         */

        List<Activity> activityList = activityService.findAll();
        model.addAttribute("activityList", activityList);

        return "index";

    }

    @GetMapping("/search")
    @ResponseBody
    public String search(String option) {
        List<Scenic> list = scenicService.findByCondition("%" + option + "%");
        return null;
    }
}
