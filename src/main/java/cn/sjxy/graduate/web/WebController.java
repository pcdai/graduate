package cn.sjxy.graduate.web;

import cn.sjxy.graduate.entity.*;
import cn.sjxy.graduate.service.*;
import cn.sjxy.graduate.utils.ConditionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/26 9:38
 */
@Controller
public class WebController {
    @Autowired
    private NewsTypeService newsTypeService;

    @Autowired
    @Resource
    private RestaurantService restaurantService;
    private MemberService memberService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ScenicApplyService scenicApplyService;
    @Autowired
    private ScenicService scenicService;

    @GetMapping("/my_index.html")
    public String my_index(Model model, HttpSession session, @RequestParam(name = "pn", defaultValue = "1", required = false) Integer pn
            , @RequestParam(name = "ps", defaultValue = "3", required = false) Integer ps) {
        Member member = (Member) session.getAttribute("member");
        Condition condition = ConditionUtil.getCondition(Comment.class);
        condition.createCriteria().andEqualTo("userId", member.getId());
        List<Comment> list = commentService.findByCondition(condition);
        System.out.println("list = " + list);
        model.addAttribute("list", list);
        model.addAttribute("size", list.size());
        String applyId = member.getScenicApplyId();
        Condition condition1 = ConditionUtil.getCondition(ScenicApply.class);
        condition.createCriteria().andIn("id", Arrays.asList(member.getScenicApplyId().split(",")));
        PageHelper.startPage(pn, ps);
        List<ScenicApply> list1 = scenicApplyService.findByCondition(condition1);
        for (ScenicApply apply : list1) {
            apply.setImg(scenicService.findBy("id", apply.getScenicId()).getIcon());
        }
        PageInfo<ScenicApply> info = new PageInfo<>(list1, 4);
        model.addAttribute("info", info);
        model.addAttribute("scenicApplyList", list1);
        model.addAttribute("size1", list1.size());

        return "my_index";
    }

    @GetMapping("/write_note.html")
    public String write_note() {
        return "write_note";
    }

    @GetMapping("/my_note.html")
    public String my_note() {
        return "my_note";
    }

    @GetMapping("/ok")
    public String ok(Model model) {
        model.addAttribute("index", new Date());
        return "ok";
    }

    @GetMapping("/collection_list.html")
    public String collection_list() {
        return "collection_list";
    }

    @GetMapping("/project_order.html")
    public String project_order() {
        return "project_order";
    }

    @GetMapping("/note_comments.html")
    public String note_comments() {
        return "note_comments";
    }

    @GetMapping("/shop_car.html")
    public String shop_car() {
        return "shop_car";
    }

    @GetMapping("/my_info.html")
    public String my_info() {
        return "my_info";
    }

    @GetMapping("/news_list.html")
    public String news_list(Model model) {
        List<NewsType> typeList = newsTypeService.findAll();

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

        model.addAttribute("typeList", typeList);
        return "news_list";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/scenic_list.html")
    public String scenic_list(Model model) {
        model.addAttribute("index", new Date());
        return "scenic_list";
    }

    /**
     * <li><a href="my_head.html"><i class="ico2"></i>我的头像</a></li>
     * <li><a href="my_contact.html"><i class="ico3"></i>常用联系人</a></li>
     * <li><a href="security.html"><i class="ico4"></i>修改密码</a></li>
     */
    @GetMapping("my_head.html")
    public String my_head() {
        return "my_head";
    }

    @GetMapping("my_contact.html")
    public String my_contact() {
        return "my_contact";
    }

    @GetMapping("security.html")
    public String security() {
        return "security";
    }
}
