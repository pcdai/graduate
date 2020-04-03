package cn.sjxy.graduate.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @Author dpc
 * @Date 2020/3/29 11:00
 */
@RestController
public class TestArrayList {
    @GetMapping("TEST")
    public String demo(){
        return "http://localhost:8080/scenic/scenicDetails?id=4";
    }

}
