package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.config.AlipayTemplate;
import cn.sjxy.graduate.entity.Member;
import cn.sjxy.graduate.entity.PayVo;
import cn.sjxy.graduate.entity.ScenicApply;
import cn.sjxy.graduate.service.MemberService;
import cn.sjxy.graduate.service.ScenicApplyService;
import cn.sjxy.graduate.service.ScenicService;
import cn.sjxy.graduate.utils.ArrayUtil;
import cn.sjxy.graduate.utils.DateUtil;
import cn.sjxy.graduate.utils.OrderNumUtil;
import com.alipay.api.AlipayApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

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
    @Autowired
    private MemberService memberService;

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
        String scenicName = (String) session.getAttribute("scenicName");
        Member member = (Member) session.getAttribute("member");
        apply.setMemberId(member.getId());
        apply.setScenicId(scenic);
        apply.setAllMoney(ticket);
        apply.setOrderName(scenicName);
        apply.setNum(num);
        apply.setMoney("" + Integer.parseInt(ticket) / num + "");
        String uuid = UUID.randomUUID().toString();
        apply.setPay(uuid);
        apply.setOrderTime(new Date());
        apply.setStatus(1);
        scenicApplyService.save(apply);
        String name = member.getName();
        String telephone = member.getTelephone();
        System.out.println("scenicApplyService.findBy(\"pay\", uuid) = " + scenicApplyService.findBy("pay", uuid));
        session.setAttribute("apply", scenicApplyService.findBy("pay", uuid));
        model.addAttribute("scenic", scenicService.findBy("id", scenic));
        model.addAttribute("ticket", ticket);
        model.addAttribute("num", num);
        model.addAttribute("name", name);
        model.addAttribute("telephone", telephone);
        String applyId = member.getScenicApplyId();
        applyId = applyId + "," + scenicApplyService.findBy("pay", uuid).getId();
        member.setScenicApplyId(applyId);
        memberService.update(member);
        return "confirm_order2";
    }

    @Autowired
    private AlipayTemplate alipayTemplate;

    @ResponseBody
    @GetMapping(value = "payOrder", produces = "text/html")
    public String payOrder(HttpSession session, Model model, String ticket, String scenicName) throws AlipayApiException {
        ScenicApply apply = (ScenicApply) session.getAttribute("apply");
        apply.setStatus(0);
        apply.setId(apply.getId());
        scenicApplyService.update(apply);
        PayVo payVo = new PayVo();
        payVo.setTotal_amount(ticket);
        payVo.setSubject(scenicName);
        payVo.setOut_trade_no(apply.getPay());
        String pay = alipayTemplate.pay(payVo);
        return pay;
    }

    @GetMapping("deleteApply/{id}")
    public String deleteApply(@PathVariable Integer id, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        String[] applyId = member.getScenicApplyId().split(",");
        String[] arr1 = {new String("" + id)};
        String[] minus = ArrayUtil.minus(arr1, applyId);
        StringBuffer buffer = new StringBuffer();
        for (String s : minus) {
            buffer.append(s + ",");
        }
        String s = buffer.toString();
        s = s.substring(0, s.length() - 1);
        System.out.println("s = " + s);
        member.setScenicApplyId(s);
        memberService.update(member);
        scenicApplyService.deleteById(id);
        return "redirect:/member/scenic_order.html";
    }
}
