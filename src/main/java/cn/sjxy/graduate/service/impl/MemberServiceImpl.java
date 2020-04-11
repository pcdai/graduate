package cn.sjxy.graduate.service.impl;


import cn.sjxy.graduate.core.service.AbstractService;
import cn.sjxy.graduate.dao.MemberDao;
import cn.sjxy.graduate.entity.Member;
import cn.sjxy.graduate.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表(Member)表服务实现类
 *
 * @author dpc
 * @since 2020-03-14 10:07:11
 */
@Service
public class MemberServiceImpl extends AbstractService<Member> implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public Member doLogin(String account, String password) {
        return memberDao.doLogin(account, password);
    }

    @Override
    public Member selectOne(Integer id) {
        return memberDao.selectOneAAA(id);
    }
}