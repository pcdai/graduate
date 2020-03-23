package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.beans.Hotel;
import cn.sjxy.graduate.dao.HotelDao;
import cn.sjxy.graduate.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Hotel)表服务实现类
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@Service("hotelService")
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;

    @Override
    public Hotel queryById(Integer id) {
        return hotelDao.queryById(id);
    }
}