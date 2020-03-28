package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Restaurant;
import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.service.RestaurantService;
import cn.sjxy.graduate.service.ScenicService;
import cn.sjxy.graduate.utils.ConditionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
 * 景点(Scenic)表控制层
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@Controller
@RequestMapping("/scenic")
public class ScenicController {
    /**
     * 服务对象
     */
    @Resource
    private ScenicService scenicService;
    @Resource
    private RestaurantService restaurantService;

    @GetMapping("/hotScenicList")
    public String hotScenicList(Model model) {
        List<Scenic> list = scenicService.queryForHotScenice();
        model.addAttribute("list", list);
        Condition condition = ConditionUtil.getCondition(Restaurant.class);
        condition.createCriteria().andEqualTo("hot", 0);
        List<Restaurant> listHot = restaurantService.findByCondition(condition);
        model.addAttribute("listHot", listHot);
        return "scenic_list";
    }

    @GetMapping("/scenicRelaxList")
    public String relaxScenicList(Model model) {
        List<Scenic> list = scenicService.relaxScenicList();
        model.addAttribute("list", list);
        return "scenic_list1";
    }

}