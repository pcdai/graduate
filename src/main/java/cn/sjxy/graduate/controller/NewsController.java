package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.News;
import cn.sjxy.graduate.service.NewsService;
import cn.sjxy.graduate.utils.ConditionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/30 19:36
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @ResponseBody
    @RequestMapping("/getNewsList")
    public List<News> getNewsList() {

        return newsService.findLimitFive();
    }

    @RequestMapping("/newsDetails")
    public String newsDetails(Integer id, Model model, HttpServletRequest request) {
        Integer count = 0;
        News news = newsService.findById(id);
        if (news != null) {
            count = news.getCount();
        }
        count += count;
        news.setCount(count);
        model.addAttribute("news", news);
        return "article.html";
    }
}
