package cn.sjxy.graduate.service;

import cn.sjxy.graduate.core.service.Service;
import cn.sjxy.graduate.entity.News;

import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/30 18:00
 */
public interface NewsService extends Service<News> {
    List<News> findLimitFive();

    List<News> findByTypeId(Integer id);
}
