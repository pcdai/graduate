package cn.sjxy.graduate.utils;

import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/28 16:08
 */
@Controller
public class TestController {
    @Autowired
    private ScenicService scenicService;

    @RequestMapping("/test1")
    public String test1(Model model) {
        model.addAttribute("list", Arrays.asList("1", "2", "3", "4"));
        Scenic scenic = scenicService.queryById(4);
        scenic.setImgList(Arrays.asList(scenic.getImg()));
        model.addAttribute("list1", scenic.getImgList());
        System.out.println(Arrays.asList("1", "2", "3", "4"));
        System.out.println(scenic.getImgList().size());
        List<String> list = scenic.getImgList();
        list.size();
        for (String s : list) {
            System.out.println("s = " + s);
        }
        return "ok";
    }
}
