package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.beans.Scenic;
import cn.sjxy.graduate.dao.ScenicDao;
import cn.sjxy.graduate.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 景点(Scenic)表服务实现类
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
@Service("scenicService")
public class ScenicServiceImpl implements ScenicService {
    @Autowired
    private ScenicDao scenicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Scenic queryById(Integer id) {
        return this.scenicDao.queryById(id);
    }


}