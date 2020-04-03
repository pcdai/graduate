package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Member;
import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.service.ScenicApplyService;
import cn.sjxy.graduate.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author dpc
 * @Date 2020/3/28 14:39
 */
@Controller
@RequestMapping("/scenicApply")
public class ScenicApply {
    @Autowired
    private ScenicApplyService scenicApplyService;
    @Autowired
    private ScenicService scenicService;

    @RequestMapping("activities_list.html")
    public String activities_list(Model model) {
        return "activities_list";
    }

    @GetMapping("confirm_order")
    public String confirm_order(HttpSession session, Model model) {
        Integer scenic = (Integer) session.getAttribute("scenic");
        String ticket = (String) session.getAttribute("ticket");
        Integer num = (Integer) session.getAttribute("num");
        Member member = (Member) session.getAttribute("member");
        String name = member.getName();
        String telephone = member.getTelephone();
        model.addAttribute("scenic", scenicService.findBy("id", scenic));
        model.addAttribute("ticket", ticket);
        model.addAttribute("num", num);
        model.addAttribute("name", name);
        model.addAttribute("telephone", telephone);
        return "confirm_order2";
    }
}
