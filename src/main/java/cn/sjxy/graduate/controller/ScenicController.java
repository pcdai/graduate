package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.*;
import cn.sjxy.graduate.entity.dto.ScenicDto;
import cn.sjxy.graduate.service.*;
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
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

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
    @Autowired
    private NewsService newsService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private ActivityService activityService;

    @GetMapping("/hotScenicList")
    public String hotScenicList(Model model) {
        /**
         * 所有景点
         */
        List<Scenic> list = scenicService.scenicList();
        model.addAttribute("list", list);
        /**
         * 美食
         */
        List<Restaurant> restList = restaurantService.selectHotLimit();
        model.addAttribute("restList", restList);
        /**
         * 新闻
         */

        List<News> newsList = newsService.findAll();
        model.addAttribute("newsList", newsList);
        /**
         * 活动
         */
        List<Activity> activityList = activityService.findAll();
        model.addAttribute("activityList", activityList);
        /**
         * 民宿
         */
        List<Hotel> hotelList = hotelService.findAll();
        model.addAttribute("hotelList", hotelList);

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
        /**
         * 附近餐厅
         */
        Condition condition1 = ConditionUtil.getCondition(Restaurant.class);
        if (!StringUtils.isEmpty(scenic.getRestId())) {
            condition1.createCriteria().andIn("id", Arrays.asList(scenic.getRestId().split(",")));
        }
        List<Restaurant> restaurantList = restaurantService.findByCondition(condition1);
        model.addAttribute("restaurantList", restaurantList);
        /**
         * 附近民宿
         */
        Condition condition = ConditionUtil.getCondition(Hotel.class);
        if (!StringUtils.isEmpty(scenic.getHotelId())) {
            condition.createCriteria().andIn("id", Arrays.asList(scenic.getHotelId().split(",")));
        }
        List<Hotel> hotelList = hotelService.findByCondition(condition);
        model.addAttribute("hotelList", hotelList);
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
    public String confirm(Integer scenicId, String ticket, Integer num,String scenicName, HttpSession session) {
        /**
         * 笨方法。。但是目前只能想到这个办法
         */
        session.setAttribute("scenic", scenicId);
        session.setAttribute("ticket", ticket);
        session.setAttribute("num", num);
        session.setAttribute("scenicName",scenicName);
        return "localhost:8080/scenicApply/confirm_order";
    }

    @GetMapping("search")
    public String search(String keyWord, Model model) {
        System.out.println("keyWord = " + keyWord);
        Condition condition = ConditionUtil.getCondition(Scenic.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andLike("name", "%" + keyWord + "%");
        Example.Criteria criteria1 = condition.createCriteria();
        criteria1.andLike("details", "%" + keyWord + "%");
        condition.or(criteria1);
        List<Scenic> scenics = scenicService.findByCondition(condition);
        model.addAttribute("scenicList", scenics);
        return "scenic_search";
    }

}