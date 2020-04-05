package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.core.service.AbstractService;
import cn.sjxy.graduate.entity.Hotel;
import cn.sjxy.graduate.dao.HotelDao;
import cn.sjxy.graduate.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Hotel)表服务实现类
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@Service("hotelService")
public class HotelServiceImpl extends AbstractService<Hotel> implements HotelService {
    @Autowired
    private HotelDao hotelDao;


}