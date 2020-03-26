package cn.sjxy.graduate.service;

import cn.sjxy.graduate.core.service.Service;
import cn.sjxy.graduate.entity.Restaurant;
import cn.sjxy.graduate.entity.dto.RestaurantDto;

/**
 * 餐厅表(Restaurant)表服务接口
 *
 * @author dpc
 * @since 2020-03-14 10:07:11
 */
public interface RestaurantService extends Service<Restaurant> {
    RestaurantDto queryForOne(Integer id);

}