package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Comment;
import cn.sjxy.graduate.entity.Member;
import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.service.CommentService;
import cn.sjxy.graduate.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Id;
import javax.servlet.http.HttpSession;

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

    @PostMapping("/addComment")
    public String addComment(HttpSession session, String comment, Integer scenicId, @RequestHeader("referer") String referer) {
        /**
         * 保存评论内容和评论的人的id到评论表，保存评论id到景点表
         */
        Member member = (Member) session.getAttribute("member");
        Comment comment1 = new Comment();
        comment1.setComment(comment);
        comment1.setUserId(member.getId());
        commentService.save(comment1);
        Comment comment2 = commentService.findBy("comment", comment);
        Integer comment2Id = comment2.getId();
        System.out.println("comment2Id = " + comment2Id);
        Scenic scenic = scenicService.queryById(scenicId);
        String commentId = scenic.getCommentId();
        commentId = commentId + "," + comment2Id;
        scenicService.addComment(scenic.getId(), commentId);
        return "redirect:" + referer;
    }

}
