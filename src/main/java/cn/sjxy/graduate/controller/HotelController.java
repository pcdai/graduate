package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Hotel;
import cn.sjxy.graduate.service.HotelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Hotel)表控制层
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@RestController
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

}