package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.core.service.AbstractService;
import cn.sjxy.graduate.dao.NewsDao;
import cn.sjxy.graduate.entity.News;
import cn.sjxy.graduate.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author dpc
 * @Date 2020/3/30 18:00
 */
@Service
public class NewsServiceImpl extends AbstractService<News> implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> findLimitFive() {
        return newsDao.findLimitFive();
    }
}
