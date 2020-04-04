package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.config.AlipayTemplate;
import cn.sjxy.graduate.entity.Member;
import cn.sjxy.graduate.entity.PayVo;
import cn.sjxy.graduate.entity.ScenicApply;
import cn.sjxy.graduate.service.ScenicApplyService;
import cn.sjxy.graduate.service.ScenicService;
import cn.sjxy.graduate.utils.DateUtil;
import cn.sjxy.graduate.utils.OrderNumUtil;
import com.alipay.api.AlipayApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author dpc
 * @Date 2020/3/28 14:39
 */
@Controller
@RequestMapping("/scenicApply")
public class ScenicApplyController {
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
        ScenicApply apply = new ScenicApply();

        Integer scenic = (Integer) session.getAttribute("scenic");
        String ticket = (String) session.getAttribute("ticket");
        Integer num = (Integer) session.getAttribute("num");
        Member member = (Member) session.getAttribute("member");
        apply.setMemberId(member.getId());
        apply.setScenicId(scenic);
        apply.setPay(ticket);
        apply.setPay(OrderNumUtil.getOrderNo());
        apply.setOrderTime(new Date());
        apply.setStatus(1);
        scenicApplyService.save(apply);
        String name = member.getName();
        String telephone = member.getTelephone();
        session.setAttribute("apply", apply);
        model.addAttribute("scenic", scenicService.findBy("id", scenic));
        model.addAttribute("ticket", ticket);
        model.addAttribute("num", num);
        model.addAttribute("name", name);
        model.addAttribute("telephone", telephone);

        return "confirm_order2";
    }

    @Autowired
    private AlipayTemplate alipayTemplate;

    @ResponseBody
    @GetMapping(value = "payOrder", produces = "text/html")
    public String payOrder(HttpSession session, Model model, String ticket, String scenicName) throws AlipayApiException {
        ScenicApply apply = (ScenicApply) session.getAttribute("apply");
        System.out.println("ticket = " + ticket);
        System.out.println("scenicName = " + scenicName);
        PayVo payVo = new PayVo();
        payVo.setTotal_amount(ticket);
        payVo.setSubject(scenicName);
        payVo.setOut_trade_no(OrderNumUtil.getOrderNo());
        String pay = alipayTemplate.pay(payVo);
        return pay;
    }
}
//要有订单编号，一个订单编号对应一个商品，