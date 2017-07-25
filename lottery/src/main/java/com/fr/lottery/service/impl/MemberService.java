package com.fr.lottery.service.impl;

import com.fr.lottery.dao.MemberMapper;
import com.fr.lottery.dao.UserMapper;
import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.Member;
import com.fr.lottery.entity.User;
import com.fr.lottery.service.inter.IMemberService;
import com.fr.lottery.service.inter.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service
public class MemberService implements IMemberService {
    @Autowired
    private MemberMapper memberMapper;

    public Member getByAccount(String loginName){
        Member result=memberMapper.getByAccount(loginName);
        return result;
    }

    /**
     * 用户分页
     * @param page
     * @param index
     * @param size
     * @return
     */

    public Page<User> getData(Page<User> page, Integer index, Integer size) {
        List<User> list=new ArrayList<User>();
        if(list!=null&&list.size()>0){
            page.setList(list);
            page.setCount(list.size());
            page.setPageNo(page.getPageNo());
        }
        return page;
    }


    @Override
    public Member get(String id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Member entity) {
        return memberMapper.insert(entity);
    }

    @Override
    public int update(Member entity) {
        return memberMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int delete(String id) {
        return memberMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updatePassword(String id, String password) {
        return  memberMapper.updatePassword(id,password);
    }

    @Override
    public List<Member> getMembersByAgentId(String agentId,String keyword,Integer status,  Integer pageId) {
        return memberMapper.getMembersByAgentId(agentId,keyword,status,pageId);
    }
}
