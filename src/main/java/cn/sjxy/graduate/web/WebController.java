package cn.sjxy.graduate.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author dpc
 * @Date 2020/3/26 9:38
 */
@Controller
public class WebController {

    @GetMapping("/my_index.html")
    public String my_index(Model model) {
        model.addAttribute("index",new Date());
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
        model.addAttribute("index",new Date());
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

    @GetMapping("/scenic_order.html")
    public String scenic_order() {
        return "scenic_order";
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
    public String news_list() {
        return "news_list";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/scenic_list.html")
    public String scenic_list(Model model) {
        model.addAttribute("index",new Date());
        return "scenic_list";
    }
}
