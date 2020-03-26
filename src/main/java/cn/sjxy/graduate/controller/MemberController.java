package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Member;
import cn.sjxy.graduate.service.MemberService;
import cn.sjxy.graduate.utils.ConditionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/25 10:13
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/doLogin")
    public String loLogin(Member member, HttpSession session) {
        Member member1 = memberService.doLogin(member.getAccount(), member.getPassword());
        if (member1 == null) {
            session.setAttribute("errorMsg", "用户名或密码错误 ");
            return "login";
        }
        session.setAttribute("member", member1);
        return "redirect:/index";
    }

    @PostMapping("/register")
    public String register(Member member, HttpSession session, Model model) {
        String code = (String) session.getAttribute("code");
        String code1 = member.getCode();
        if (!code.equals(code1)) {
            model.addAttribute("errorMsg", "验证码错误");
            return "register";
        }
        Condition condition = ConditionUtil.getCondition(Member.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("account", member.getAccount());
        List<Member> members = memberService.findByCondition(condition);
        if (!CollectionUtils.isEmpty(members)) {
            model.addAttribute("errorMsg1", "账号已被注册");
            return "register";
        }
        Condition condition1 = ConditionUtil.getCondition(Member.class);
        Example.Criteria criteria1 = condition.createCriteria();
        criteria1.andEqualTo("email", member.getEmail());
        List<Member> byCondition = memberService.findByCondition(condition1);
        if (!CollectionUtils.isEmpty(byCondition)) {
            model.addAttribute("errorMsg2", "邮箱已被注册");
            return "register";
        }
        memberService.save(member);
        return "login";
    }

}
