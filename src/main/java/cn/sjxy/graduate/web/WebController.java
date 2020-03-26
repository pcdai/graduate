package cn.sjxy.graduate.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author dpc
 * @Date 2020/3/26 9:38
 */
@Controller
public class WebController {
    /**
     * <li><a href="${ctxPath}/my_index.html"><i class="i1"></i>我的主页</a></li>
     * <li><a href="${ctxPath}/write_note.html"><i class="i2"></i>写游记</a></li>
     * <li><a href="${ctxPath}/my_note.html"><i class="i9"></i>我的游记</a></li>
     * <li><a href="${ctxPath}/collection_list.html"><i class="i3"></i>我的收藏</a></li>
     * <li><a href="${ctxPath}/project_order.html"><i class="i4"></i>商品订单</a></li>
     * <li><a href="${ctxPath}/scenic_order.html"><i class="i5"></i>旅游订单</a></li>
     * <li><a href="${ctxPath}/note_comments.html"><i class="i6"></i>我的评论</a></li>
     * <li><a href="${ctxPath}/my_info.html"><i class="i7"></i>设置</a></li>
     * <li><a href="${ctxPath}/logout"><i class="i8"></i>退出</a></li>
     * <li class="tb"><a href="${ctxPath}/shop_car.html"><i class="cart_ico"></i>购物车</a><span>|</span></li>
     * <li class="tb"><a href="${ctxPath}/news_list.html">用户帮助中心</a><span>|</span></li>
     */
    @GetMapping("/my_index.html")
    public String my_index() {
        return "my_index.html";
    }

    @GetMapping("/write_note.html")
    public String write_note() {
        return "write_note.html";
    }

    @GetMapping("/my_note.html")
    public String my_note() {
        return "my_note.html";
    }

    @GetMapping("/collection_list.html")
    public String collection_list() {
        return "collection_list.html";
    }

    @GetMapping("/project_order.html")
    public String project_order() {
        return "project_order.html";
    }

    @GetMapping("/scenic_order.html")
    public String scenic_order() {
        return "scenic_order.html";
    }

    @GetMapping("/note_comments.html")
    public String note_comments() {
        return "note_comments.html";
    }

    @GetMapping("/shop_car.html")
    public String shop_car() {
        return "shop_car.html";
    }

    @GetMapping("/my_info.html")
    public String my_info() {
        return "my_info.html";
    }

    @GetMapping("/news_list.html")
    public String news_list() {
        return "news_list.html";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/scenic_list.html")
    public String scenic_list() {
        return "scenic_list.html";
    }
}
