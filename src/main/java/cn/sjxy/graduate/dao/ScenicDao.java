package cn.sjxy.graduate.dao;


import java.util.List;

import cn.sjxy.graduate.entity.Comment;
import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.entity.ScenicExample;
import cn.sjxy.graduate.entity.dto.CommentDto;
import cn.sjxy.graduate.entity.dto.ScenicDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ScenicDao extends cn.sjxy.graduate.core.mapper.Mapper<Scenic> {

    List<Scenic> queryAllHotScenicLimitFour();

    List<Scenic> queryForRelax();

    List<Scenic> findByCondition(String option);

    List<Scenic> queryForHotScenice();

    List<Scenic> relaxScenicList();

    List<Scenic> scenicList();

    List<Scenic> queryforScenic();

    Scenic queryForId(Integer id);


    ScenicDto selectCommentByScenicId(Integer id);

    void addComment(Integer id, String commentId);
}