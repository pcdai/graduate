package cn.sjxy.graduate.dao;

import cn.sjxy.graduate.core.mapper.Mapper;
import cn.sjxy.graduate.entity.News;

import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/30 17:59
 */
@org.apache.ibatis.annotations.Mapper
public interface NewsDao extends Mapper<News> {
    List<News> findLimitFive();
}
