package cn.sjxy.graduate.service.impl;

import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.dao.ScenicDao;
import cn.sjxy.graduate.entity.ScenicExample;
import cn.sjxy.graduate.entity.dto.ScenicDto;
import cn.sjxy.graduate.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Scenic queryById(Integer id) {
        return scenicDao.queryForId(id);
    }

    @Override
    public List<Scenic> queryAllHotScenicLimitFour() {
        return scenicDao.queryAllHotScenicLimitFour();
    }

    @Override
    public void save(Scenic scenic) {
        scenicDao.insertSelective(scenic);
    }

    @Override
    public List<Scenic> queryForRelax() {
        return scenicDao.queryForRelax();
    }

    @Override
    public List<Scenic> findByCondition(String option) {
        return scenicDao.findByCondition(option);
    }

    @Override
    public List<Scenic> queryForHotScenice() {
        return scenicDao.queryForHotScenice();
    }

    @Override
    public List<Scenic> relaxScenicList() {
        return scenicDao.relaxScenicList();
    }

    @Override
    public List<Scenic> scenicList() {
        return scenicDao.scenicList();
    }

    @Override
    public List<Scenic> queryForScenic() {
        return scenicDao.queryforScenic();
    }

    @Override
    public ScenicDto selectCommentByScenicId(Integer id) {
        return scenicDao.selectCommentByScenicId(id);
    }

    @Override
    public void addComment(Integer id, String commentId) {
        scenicDao.addComment(id, commentId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

}