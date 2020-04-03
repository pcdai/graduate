package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.News;
import cn.sjxy.graduate.entity.NewsType;
import cn.sjxy.graduate.service.NewsService;
import cn.sjxy.graduate.service.NewsTypeService;
import cn.sjxy.graduate.utils.ConditionUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
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
    @Autowired
    private NewsTypeService newsTypeService;

    @ResponseBody
    @RequestMapping("/getNewsList")
    public List<News> getNewsList() {

        return newsService.findLimitFive();
    }

    @ResponseBody
    @RequestMapping("/getNewsTypeList")
    public List<NewsType> getNewsTypeList() {

        return newsTypeService.findAll();
    }

    @ResponseBody
    @RequestMapping("/getNewsListByTypeId")
    public List<News> getNewsListByTypeId(Integer id) {

        return newsService.findByTypeId(id);
    }

    @RequestMapping("/newsDetails")
    public String newsDetails(Integer id, Model model, HttpServletRequest request) {
        News news = newsService.findById(id);
        if (news != null && !StringUtils.isEmpty(news.getImg())) {
            String[] split = news.getDetails().split("@@@");
            if (split.length <= 1) {
                news.setDetailsList(Arrays.asList(news.getDetails()));
            }
            news.setDetailsList(Arrays.asList(split));
        }
        if (news != null && !StringUtils.isEmpty(news.getImg())) {
            news.setImgList(Arrays.asList(news.getImg().split(",")));
        }
        Integer count = news.getCount();
        count = count + 1;
        news.setCount(count);
        newsService.update(news);
        model.addAttribute("news", news);
        model.addAttribute("times", count);
        return "article";

    }
}
