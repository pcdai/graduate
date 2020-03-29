package cn.sjxy.graduate.service;

import cn.sjxy.graduate.entity.Comment;
import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.entity.dto.ScenicDto;

import java.util.List;

/**
 * 景点(Scenic)表服务接口
 *
 * @author dpc
 * @since 2020-03-23 16:03:09
 */
public interface ScenicService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Scenic queryById(Integer id);

    /**
     * 查询热门景点前四位
     *
     * @param hot
     * @return
     */
    List<Scenic> queryAllHotScenicLimitFour();

    void save(Scenic scenic);

    /**
     * 见名知意
     *
     * @return
     */
    List<Scenic> queryForRelax();

    List<Scenic> findByCondition(String option);

    List<Scenic> queryForHotScenice();

    List<Scenic> relaxScenicList();

    List<Scenic> scenicList();

    List<Scenic> queryForScenic();

    ScenicDto selectCommentByScenicId(Integer id);
}