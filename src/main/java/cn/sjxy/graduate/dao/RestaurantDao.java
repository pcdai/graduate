package cn.sjxy.graduate.dao;

import cn.sjxy.graduate.beans.Restaurant;
import cn.sjxy.graduate.core.mapper.Mapper;


/**
 * 餐厅表(Restaurant)表数据库访问层
 *
 * @author dpc
 * @since 2020-03-14 10:07:11
 */
@org.apache.ibatis.annotations.Mapper
public interface RestaurantDao extends Mapper<Restaurant> {


}