package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.beans.Scenic;
import cn.sjxy.graduate.service.ScenicService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 景点(Scenic)表控制层
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@RestController
@RequestMapping("scenic")
public class ScenicController {
    /**
     * 服务对象
     */
    @Resource
    private ScenicService scenicService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Scenic selectOne(Integer id) {
        return this.scenicService.queryById(id);
    }

}