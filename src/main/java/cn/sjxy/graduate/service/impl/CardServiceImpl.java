package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.entity.Card;
import cn.sjxy.graduate.core.service.AbstractService;
import cn.sjxy.graduate.dao.CardDao;
import cn.sjxy.graduate.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther dpc
 * @Date 2020/3/23 14:46
 */
@Service
public class CardServiceImpl extends AbstractService<Card> implements CardService {
    @Autowired
    private CardDao cardDao;
}
