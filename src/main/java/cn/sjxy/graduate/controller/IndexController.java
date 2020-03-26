package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Restaurant;
import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.service.RestaurantService;
import cn.sjxy.graduate.service.ScenicService;
import cn.sjxy.graduate.utils.ConditionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Condition;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    @RequestMapping("/index")
    public String initIndex(HttpSession session, Model model) {
        List<Scenic> scenics = scenicService.queryAllHotScenicLimitFour();
        model.addAttribute("scenics", scenics);
        return "index";
    }
}
