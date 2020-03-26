package cn.sjxy.graduate.dao;


import java.util.List;

import cn.sjxy.graduate.entity.Scenic;
import cn.sjxy.graduate.entity.ScenicExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ScenicDao {

    List<Scenic> queryAllHotScenicLimitFour();
}