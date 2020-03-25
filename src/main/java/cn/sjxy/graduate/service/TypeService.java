package cn.sjxy.graduate.service;

import cn.sjxy.graduate.entity.Type;

/**
 * 景点分类表(Type)表服务接口
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
public interface TypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Type queryById(Integer id);

}