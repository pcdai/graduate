package cn.sjxy.graduate.dao;


import cn.sjxy.graduate.entity.Member;
import cn.sjxy.graduate.core.mapper.Mapper;

/**
 * 用户表(Member)表数据库访问层
 *
 * @author dpc
 * @since 2020-03-14 10:07:11
 */
@org.apache.ibatis.annotations.Mapper
public interface MemberDao extends Mapper<Member> {

    Member doLogin(String account, String password);
}