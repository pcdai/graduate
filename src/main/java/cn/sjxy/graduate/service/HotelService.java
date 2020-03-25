package cn.sjxy.graduate.service;

import cn.sjxy.graduate.entity.Hotel;

/**
 * (Hotel)表服务接口
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
public interface HotelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Hotel queryById(Integer id);


}