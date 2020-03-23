package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.core.service.AbstractService;
import cn.sjxy.graduate.beans.Style;
import cn.sjxy.graduate.dao.StyleDao;
import cn.sjxy.graduate.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 风格表(Style)表服务实现类
 *
 * @author dpc
 * @since 2020-03-14 10:07:11
 */
@Service
public class StyleServiceImpl extends AbstractService<Style> implements StyleService {
    @Autowired
    private StyleDao styleDao;
}