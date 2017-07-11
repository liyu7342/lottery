package com.fr.lottery.dao;

import com.yunfang.inquiry.entity1.Member;
import com.yunfang.inquiry.entity1.MemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {
    long countByExample(MemberExample example);

    int deleteByPrimaryKey(String id);

    int insert(Member record);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(String id);


    int updateByPrimaryKey(Member record);
}