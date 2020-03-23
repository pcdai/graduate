package cn.sjxy.graduate.core.mapper;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @Author: dpc
 * @Date: 2020/1/15 15:20
 * 通用Mapper 有基本的增删改查（包括插入多个，删除多个），根据条件查询，下面每个BeanMapper都需要继承该Mapper
 */
public interface Mapper<T> extends BaseMapper<T>, IdsMapper<T>, ConditionMapper<T>, InsertListMapper<T> {
}
