package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.core.service.AbstractService;
import cn.sjxy.graduate.entity.Restaurant;
import cn.sjxy.graduate.dao.RestaurantDao;
import cn.sjxy.graduate.entity.dto.RestaurantDto;
import cn.sjxy.graduate.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 餐厅表(Restaurant)表服务实现类
 *
 * @author dpc
 * @since 2020-03-14 10:07:11
 */
@Service
public class RestaurantServiceImpl extends AbstractService<Restaurant> implements RestaurantService {
    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public RestaurantDto queryForOne(Integer id) {
        return restaurantDao.queryForOne(id);
    }
}