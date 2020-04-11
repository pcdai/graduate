package cn.sjxy.graduate.service;

import cn.sjxy.graduate.core.service.Service;
import cn.sjxy.graduate.entity.Member;


/**
 * 用户表(Member)表服务接口
 *
 * @author dpc
 * @since 2020-03-14 10:07:11
 */
public interface MemberService extends Service<Member> {

    Member doLogin(String account, String password);
    Member selectOne(Integer id);
}