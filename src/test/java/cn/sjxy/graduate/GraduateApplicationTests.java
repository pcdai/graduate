package cn.sjxy.graduate;

import cn.sjxy.graduate.dao.RestaurantDao;
import cn.sjxy.graduate.dao.ScenicDao;
import cn.sjxy.graduate.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GraduateApplicationTests {
    @Autowired
    private ScenicDao scenicDao;
    @Test
    public void test(){

    }
}
