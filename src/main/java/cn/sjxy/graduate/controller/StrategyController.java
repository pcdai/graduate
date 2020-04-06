package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Comment;
import cn.sjxy.graduate.entity.Member;
import cn.sjxy.graduate.entity.Strategy;
import cn.sjxy.graduate.service.*;
import cn.sjxy.graduate.utils.ConditionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Condition;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @Author dpc
 * @Date 2020/4/5 10:06
 */
@Controller
@RequestMapping("/strategy")
public class StrategyController {
    @Autowired
    private StrategyService strategyService;

    @Autowired
    private MemberService memberService;
    @Autowired
    private ScenicService scenicService;
    @Autowired
    private CommentService commentService;

    public void init(Model model) {
        ModelAndView view = new ModelAndView();
        List<Strategy> strategyList = strategyService.findAll();
        for (Strategy strategy : strategyList) {
            strategy.setUserName(memberService.findBy("id", strategy.getMemberId()).getName());
            strategy.setUserPhoto(memberService.findBy("id", strategy.getMemberId()).getPhoto());
            strategy.setScenicName(scenicService.findBy("id", strategy.getScenicId()).getName());
        }
        model.addAttribute("strategyList", strategyList);
    }

    @GetMapping("note_list.html")
    public String note_list(Model model) {
        init(model);
        return "note_list";
    }

    @GetMapping("strategyDetails")
    public String strategyDetails(Integer id, Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("member");
        Strategy strategy = strategyService.findById(id);
        strategy.setUserName(memberService.findBy("id", strategy.getMemberId()).getName());
        strategy.setUserPhoto(memberService.findBy("id", strategy.getMemberId()).getPhoto());
        strategy.setImgList(Arrays.asList(strategy.getImg().split(",")));
        strategy.setScenicName(scenicService.findBy("id", strategy.getScenicId()).getName());
        strategy.setIntroduceList(Arrays.asList(strategy.getIntroduce().split("@@@")));
        init(model);
        model.addAttribute("strategy", strategy);
        return "note";
    }

    @GetMapping("strategyCommentDesc")
    @ResponseBody
    public PageInfo strategyCommentDesc(Integer id, String pid, @RequestParam(name = "pn", defaultValue = "1", required = false) Integer pn
            , @RequestParam(name = "ps", defaultValue = "4", required = false) Integer ps) {
        List<Comment> comments = null;
        PageInfo<Comment> info = null;
        Strategy strategy = strategyService.findById(id);
        if (strategy != null && !StringUtils.isEmpty(strategy.getCommentId())) {
            strategy.setCommentList(Arrays.asList(strategy.getCommentId().split(",")));
            System.out.println("攻略为：" + id + "对应的评论id为：" + strategy.getCommentList());
            Condition condition = ConditionUtil.getCondition(Strategy.class);
            if (strategy.getCommentList() != null) {
                condition.createCriteria().andIn("id", strategy.getCommentList());
                if (pid != null) {
                    condition.orderBy("id").desc();
                }
                PageHelper.startPage(pn, ps);
                comments = commentService.findByCondition(condition);
            }
        }
        if (!CollectionUtils.isEmpty(comments)) {
            for (Comment comment : comments) {
                comment.setMemberName(memberService.findBy("id", comment.getUserId()).getName());
                comment.setPhone(memberService.findBy("id", comment.getUserId()).getPhoto());
            }
        }
        info = new PageInfo<>(comments, 4);
        return info;

    }
}
