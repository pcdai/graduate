package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Comment;
import cn.sjxy.graduate.entity.Member;
import cn.sjxy.graduate.entity.Restaurant;
import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.entity.dto.ScenicDto;
import cn.sjxy.graduate.service.CommentService;
import cn.sjxy.graduate.service.MemberService;
import cn.sjxy.graduate.service.RestaurantService;
import cn.sjxy.graduate.service.ScenicService;
import cn.sjxy.graduate.utils.ConditionUtil;
import cn.sjxy.graduate.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    @Autowired
    private CommentService commentService;
    @Autowired
    private MemberService memberService;

    @GetMapping("/hotScenicList")
    public String hotScenicList(Model model) {
        List<Scenic> list = scenicService.scenicList();
        model.addAttribute("list", list);
        Condition condition = ConditionUtil.getCondition(Restaurant.class);
        condition.createCriteria().andEqualTo("hot", 0);
        List<Restaurant> listHot = restaurantService.findByCondition(condition);
        model.addAttribute("listHot", listHot);
        return "scenic_list";
    }

    @GetMapping("/scenicDetails")
    public String scenicDetails(Integer id, Model model) {
        /**
         * 景点各种信息
         */
        Scenic scenic = scenicService.queryById(id);
        if (!StringUtils.isEmpty(scenic.getImg())) {
            scenic.setImgList(Arrays.asList(scenic.getImg().split(",")));
        }
        model.addAttribute("scenic", scenic);
        /**
         * 景点评论
         */
        return "scenic";
    }

    @GetMapping("/scenicCommentDesc")
    @ResponseBody
    public PageInfo scenicCommentDesc(Integer id, String pid, @RequestParam(name = "pn", defaultValue = "1", required = false) Integer pn
            , @RequestParam(name = "ps", defaultValue = "4", required = false) Integer ps) {
        List<Comment> comments = null;
        PageInfo<Comment> info = null;
        ScenicDto scenicDto = scenicService.selectCommentByScenicId(id);
        if (scenicDto != null && !StringUtils.isEmpty(scenicDto.getCommentId())) {
            scenicDto.setComment(Arrays.asList(scenicDto.getCommentId().split(",")));
            System.out.println("景区为：" + id + "对应的评论id为：" + scenicDto.getComment());
            Condition condition = ConditionUtil.getCondition(Comment.class);
            if (scenicDto.getComment() != null) {
                condition.createCriteria().andIn("id", scenicDto.getComment());
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
            info = new PageInfo<>(comments, 5);
        }

        return info;
    }

    @GetMapping("/submit_orders.html")
    public String submit_orders(Integer id, Model model, HttpSession session) {
        Scenic scenic = scenicService.queryById(id);
        Member member = (Member) session.getAttribute("member");
        String name = member.getName();
        String telephone = member.getTelephone();
        String date = DateUtil.format(new Date(), "yyyy-MM-dd");
        model.addAttribute("name", name);
        model.addAttribute("telephone", telephone);
        model.addAttribute("date", date);
        model.addAttribute("scenic", scenic);
        return "submit_orders";
    }

    @GetMapping("/confirm")
    @ResponseBody
    public String confirm(Integer scenicId,String ticket,Integer num,HttpSession session) {
        /**
         * 笨方法。。但是目前只能想到这个办法
         */
        session.setAttribute("scenic",scenicId);
            session.setAttribute("ticket",ticket);
            session.setAttribute("num",num);
            return "localhost:8080/scenicApply/confirm_order";
    }

}