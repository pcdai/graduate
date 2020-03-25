package cn.sjxy.graduate;

import cn.sjxy.graduate.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GraduateApplicationTests {
    @Autowired
    private CardService cardService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private ScenicService scenicService;
    @Autowired
    private ScenicApplyService scenicApplyService;
    @Autowired
    private HotelApplyService hotelApplyService;

    @Autowired
    private StrategyService strategyService;
    @Autowired
    private StyleService styleService;
    @Autowired
    private TypeService typeService;
@Autowired
FileService fileService;

    @Test
    void test1() {

        System.out.println("typeService.queryById(1) = " + fileService.findAll());

    }

}
