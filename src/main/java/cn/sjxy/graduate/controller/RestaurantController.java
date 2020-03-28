package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Restaurant;
import cn.sjxy.graduate.service.RestaurantService;
import cn.sjxy.graduate.utils.ConditionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/28 11:19
 */
@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping("/restaurantHot")
    public String restaurantHot(Model model) {

        return "scenic_list";
    }
}
