package cn.sjxy.graduate.dao;

import cn.sjxy.graduate.beans.Scenic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 景点(Scenic)表数据库访问层
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@Mapper
public interface ScenicDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Scenic queryById(Integer id);


}