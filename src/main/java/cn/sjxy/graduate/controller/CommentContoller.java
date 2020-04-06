package cn.sjxy.graduate.controller;

import cn.hutool.core.date.DateUnit;
import cn.sjxy.graduate.entity.Comment;
import cn.sjxy.graduate.entity.Member;
import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.entity.Strategy;
import cn.sjxy.graduate.service.CommentService;
import cn.sjxy.graduate.service.ScenicService;
import cn.sjxy.graduate.service.StrategyService;
import cn.sjxy.graduate.utils.Data;
import cn.sjxy.graduate.utils.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Id;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author dpc
 * @Date 2020/3/29 17:58
 */
@Controller
@RequestMapping("/comment")
public class CommentContoller {
    @Autowired
    private CommentService commentService;
    @Autowired
    private ScenicService scenicService;
    @Autowired
    private StrategyService strategyService;

    @PostMapping("/addComment")
    public String addComment(HttpSession session, String comment, Integer scenicId, String strategyId, @RequestHeader("referer") String referer) {
        /**
         * 保存评论内容和评论的人的id到评论表，保存评论id到景点表
         */
        Member member = (Member) session.getAttribute("member");
        Comment comment1 = new Comment();
        comment1.setComment(comment);
        comment1.setUserId(member.getId());
        comment1.setCommentTime(new Date());
        commentService.save(comment1);
        Comment comment2 = commentService.findBy("comment", comment);
        Integer comment2Id = comment2.getId();
        if (scenicId != null) {
            Scenic scenic = scenicService.queryById(scenicId);
            String commentId = scenic.getCommentId();
            commentId = commentId + "," + comment2Id;
            scenicService.addComment(scenic.getId(), commentId);
        }
        if (strategyId != null) {
            Strategy strategy = strategyService.findById(strategyId);
            String commentId1 = strategy.getCommentId();
            commentId1 = commentId1 + "," + comment2Id;
            strategy.setCommentId(commentId1);
            strategyService.update(strategy);
        }
        return "redirect:" + referer;
    }
}
