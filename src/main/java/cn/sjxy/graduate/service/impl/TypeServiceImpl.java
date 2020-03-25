package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.entity.Type;
import cn.sjxy.graduate.dao.TypeDao;
import cn.sjxy.graduate.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 景点分类表(Type)表服务实现类
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;

    @Override
    public Type queryById(Integer id) {
        return typeDao.queryById(id);
    }
}