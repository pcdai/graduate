package cn.sjxy.graduate;

import cn.sjxy.graduate.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GraduateApplicationTests {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private ScenicService scenicService;
    @Autowired
    private TypeService typeService;

    @Test
    void test1() {
       /* System.out.println("cardService.findAll() = " + cardService.findAll());
        System.out.println("cardService.findAll() = " + hotelApplyService.findAll());
        System.out.println("cardService.findAll() = " + memberService.findAll());
        System.out.println("cardService.findAll() = " + restaurantService.findAll());
        System.out.println("cardService.findAll() = " + scenicApplyService.findAll());*/
        //System.out.println("cardService.findAll() = " + scenicService.findAll());
   /*     System.out.println("cardService.findAll() = " + strategyService.findAll());
        System.out.println("cardService.findAll() = " + styleService.findAll());*/
        // System.out.println("cardService.findAll() = " + typeService.findAll());
/*        System.out.println("typeService.queryById(1) = " + typeService.queryById(1));
        System.out.println("scenicService.queryById(1) = " + scenicService.queryById(1));*/
        System.out.println("typeService.queryById(1) = " + hotelService.queryById(1));

    }

}
