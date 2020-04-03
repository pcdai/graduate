package cn.sjxy.graduate;

import cn.sjxy.graduate.dao.RestaurantDao;
import cn.sjxy.graduate.entity.Comment;
import cn.sjxy.graduate.entity.News;
import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.entity.dto.ScenicDto;
import cn.sjxy.graduate.service.*;
import cn.sjxy.graduate.utils.ConditionUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class GraduateApplicationTests {
    @Autowired
    private ScenicService scenicService;
    @Autowired
    private RestaurantDao restaurantDao;
    @Autowired
    private MemberService memberService;

    @Test
    public void test() {

    }

    @Autowired
    private CommentService commentService;

    @Test
    public void test1() {
        /**
         * 查询4 号景点的评论和评论的用户
         */
       /* Scenic scenic = scenicService.(4);
        Comment scenicId = commentService.findBy("id", scenic.getCommentId());
        Integer id = scenicId.getUserId();
        System.out.println(id);*/
    }

    @Test
    public void test2() {
        ScenicDto scenicDtos = scenicService.selectCommentByScenicId(4);
        if (!StringUtils.isEmpty(scenicDtos.getCommentId())) {
            scenicDtos.setComment(Arrays.asList(scenicDtos.getCommentId().split(",")));
        }
        Condition condition = ConditionUtil.getCondition(Comment.class);
        condition.createCriteria().andIn("id", scenicDtos.getComment());
        List<Comment> comments = commentService.findByCondition(condition);

        for (Comment comment : comments) {
            System.out.println(comment.getUserId());
        }

    }

    @Test
    public void test4() {
        ScenicDto scenicDto = scenicService.selectCommentByScenicId(4);
        System.out.println("scenicDto = " + scenicDto);
        if (!StringUtils.isEmpty(scenicDto.getCommentId())) {
            scenicDto.setComment(Arrays.asList(scenicDto.getCommentId().split(",")));
        }
        Condition condition = ConditionUtil.getCondition(Comment.class);
        condition.createCriteria().andIn("id", scenicDto.getComment());

        List<Comment> comments = commentService.findByCondition(condition);

        ArrayList<Integer> list = new ArrayList<>();
        for (Comment comment : comments) {
            comment.setMemberName( memberService.findBy("id",comment.getUserId()).getName());
            System.out.println(comment.getMemberName());
        }
    }
    @Autowired
    private NewsService newsService;
    @Test
    public void test6(){
        System.out.println("newsService.findAll() = " + newsService.findAll());
    }
    @Test
    public void test7(){
        List<News> five = newsService.findLimitFive();
        for (News news : five) {

        }
    }
    @Test
    public void test8(){
        for (News news : newsService.findLimitFive()) {
            System.out.println("news = " + news);
        }
    }
    @Test
    public void test9(){
        for (Scenic scenic : scenicService.findAll()) {
            System.out.println("scenic = " + scenic);
        }
    }
}
