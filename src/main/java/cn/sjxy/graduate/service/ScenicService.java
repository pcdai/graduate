package cn.sjxy.graduate.service;

import cn.sjxy.graduate.beans.Scenic;
import java.util.List;

/**
 * 景点(Scenic)表服务接口
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
public interface ScenicService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Scenic queryById(Integer id);



}