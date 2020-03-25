package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.core.service.AbstractService;
import cn.sjxy.graduate.entity.ScenicApply;
import cn.sjxy.graduate.dao.ScenicApplyDao;
import cn.sjxy.graduate.service.ScenicApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 景点申请(ScenicApply)表服务实现类
 *
 * @author dpc
 * @since 2020-03-14 10:07:11
 */
@Service
public class ScenicApplyServiceImpl extends AbstractService<ScenicApply> implements ScenicApplyService {
    @Autowired
    private ScenicApplyDao scenicApplyDao;
}