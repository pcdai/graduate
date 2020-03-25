package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.core.service.AbstractService;
import cn.sjxy.graduate.entity.Strategy;
import cn.sjxy.graduate.dao.StrategyDao;
import cn.sjxy.graduate.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 攻略(Strategy)表服务实现类
 *
 * @author dpc
 * @since 2020-03-14 10:07:11
 */
@Service
public class StrategyServiceImpl extends AbstractService<Strategy> implements StrategyService {
    @Autowired
    private StrategyDao strategyDao;
}