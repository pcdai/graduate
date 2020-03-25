package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.core.service.AbstractService;
import cn.sjxy.graduate.entity.HotelApply;
import cn.sjxy.graduate.dao.HotelApplyDao;
import cn.sjxy.graduate.service.HotelApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 民宿申请(HotelApply)表服务实现类
 *
 * @author dpc
 * @since 2020-03-14 10:07:10
 */
@Service
public class HotelApplyServiceImpl extends AbstractService<HotelApply> implements HotelApplyService {
    @Autowired
    private HotelApplyDao hotelApplyDao;
}