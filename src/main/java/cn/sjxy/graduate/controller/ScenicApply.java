package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.service.ScenicApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author dpc
 * @Date 2020/3/28 14:39
 */
@Controller
@RequestMapping("/scenicApply")
public class ScenicApply {
    @Autowired
    private ScenicApplyService scenicApplyService;

    @RequestMapping("activities_list.html")
    public String activities_list(Model model) {
        return "activities_list";

    }
}
