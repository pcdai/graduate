package cn.sjxy.graduate.controller;

import cn.sjxy.graduate.entity.Type;
import cn.sjxy.graduate.service.TypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 景点分类表(Type)表控制层
 *
 * @author dpc
 * @since 2020-03-23 16:03:10
 */
@RestController
@RequestMapping("type")
public class TypeController {
    /**
     * 服务对象
     */
    @Resource
    private TypeService typeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Type selectOne(Integer id) {
        return this.typeService.queryById(id);
    }

}