package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Hotel;
import cn.sjxy.graduate.service.HotelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * (Hotel)表控制层
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@Controller
@RequestMapping("hotel")
public class HotelController {
    /**
     * 服务对象
     */
    @Resource
    private HotelService hotelService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("hotelDetails")
    public String hotelDetails(Integer id, Model model) {
        Hotel hotel = hotelService.findById(id);
        if (hotel != null && !StringUtils.isEmpty(hotel.getImg())) {
            hotel.setImgList(Arrays.asList(hotel.getImg().split(",")));

        }
        model.addAttribute("hotel", hotel);
        return "";
    }
}