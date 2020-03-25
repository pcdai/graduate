package cn.sjxy.graduate.dao;

import cn.sjxy.graduate.entity.Hotel;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Hotel)表数据库访问层
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@Mapper
public interface HotelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Hotel queryById(Integer id);


}