package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Member;
import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.entity.ScenicApply;
import cn.sjxy.graduate.service.MemberService;
import cn.sjxy.graduate.service.ScenicApplyService;
import cn.sjxy.graduate.service.ScenicService;
import cn.sjxy.graduate.utils.ConditionUtil;
import cn.sjxy.graduate.utils.FileUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
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
    @Autowired
    private ScenicApplyService scenicApplyService;
    @Autowired
    private ScenicService scenicService;

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
    public String register(String account, String password, String email, String code1, String name, HttpSession session, Model model, @RequestParam("photo") MultipartFile file) {
        System.out.println("file = " + file);
        String code = (String) session.getAttribute("code");
        if (!StringUtils.isEmpty(code) && !code.equals(code1)) {
            model.addAttribute("errorMsg", "验证码错误");
            System.out.println("file = " + file);
            return "register";
        }
        System.out.println("file1111 = " + file);
        Condition condition = ConditionUtil.getCondition(Member.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("account", account);
        List<Member> members = memberService.findByCondition(condition);
        if (!CollectionUtils.isEmpty(members)) {
            model.addAttribute("errorMsg1", "账号已被注册");
            return "register";
        }
        condition.clear();
        condition.createCriteria().andEqualTo("email", email);
        List<Member> memberList = memberService.findByCondition(condition);
        System.out.println("memberList = " + memberList);
        if (!CollectionUtils.isEmpty(memberList)) {
            model.addAttribute("errorMsg2", "邮箱已被注册");
            return "register";
        }
        String upload = FileUtil.fileUpload(file);
        System.out.println(upload);
        Member member = new Member();
        member.setAccount(account);
        member.setPassword(password);
        member.setEmail(email);
        member.setPhoto(upload);
        member.setName(name);
        memberService.save(member);
        return "login";
    }

    @RequestMapping("scenic_order.html")
    public String scenic_order(@RequestParam(name = "pn", defaultValue = "1", required = false) Integer pn
            , @RequestParam(name = "ps", defaultValue = "4", required = false) Integer ps, HttpSession session, Model model) {

        Member member = (Member) session.getAttribute("member");
        Condition condition = ConditionUtil.getCondition(ScenicApply.class);
        System.out.println(Arrays.asList(member.getScenicApplyId().split(",")));
        condition.createCriteria().andIn("id", Arrays.asList(member.getScenicApplyId().split(",")));
        PageHelper.startPage(pn, ps);
        List<ScenicApply> scenicApplyList = scenicApplyService.findByCondition(condition);
        for (ScenicApply scenicApply : scenicApplyList) {
            scenicApply.setImg(scenicService.findById(scenicApply.getScenicId()).getIcon());
        }
        PageInfo<ScenicApply> info = new PageInfo<>(scenicApplyList, 5);
        System.out.println("info = " + info);
        model.addAttribute("info", info);
        return "scenic_order";
    }

    /**
     * <li><a href="my_head.html"><i class="ico2"></i>我的头像</a></li>
     * <li><a href="my_contact.html"><i class="ico3"></i>常用联系人</a></li>
     * <li><a href="security.html"><i class="ico4"></i>修改密码</a></li>
     */
    @PutMapping("editMember")
    public String editMember(HttpSession session, String name, @RequestHeader("referer") String ref) {
        Member member = (Member) session.getAttribute("member");
        member.setName(name);
        memberService.update(member);
        session.setAttribute("member", member);
        return "redirect" + ref;
    }

    @PostMapping("editPassword")
    public String editPassword(String oldPassword, String newPassword1, String newPassword2, HttpSession session, Model model, @RequestHeader("referer") String ref) {
        Member member = (Member) session.getAttribute("member");
        if (!oldPassword.equals(member.getPassword())) {
            model.addAttribute("errorMsg1", "旧密码输入错误");
        } else if (!newPassword1.equals(newPassword2)) {
            model.addAttribute("errorMsg2", "两次密码输入不一致");
        } else {
            member.setPassword(newPassword1);
            memberService.update(member);
            session.setAttribute("member", member);
        }
        return "redirect" + ref;
    }

    @PostMapping("editPhoto")
    public String editPhoto(HttpSession session, Model model, @RequestHeader("referer") String ref, @RequestParam("photo") MultipartFile file) {
        String upload = FileUtil.fileUpload(file);
        Member member = (Member) session.getAttribute("member");
        member.setPhoto(upload);
        memberService.update(member);
        session.setAttribute("member", member);
        return "redirect" + ref;
    }


}
