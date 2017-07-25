package com.fr.lottery.dao;

import com.fr.lottery.entity.Member; 
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMapper {
    long countByExample(Member example);

    int deleteByPrimaryKey(String id);

    int insert(Member record);

    List<Member> findAll(Member example);

    Member selectByPrimaryKey(String id);

    int updateByPrimaryKey(Member record);

    Member getByAccount(String account);

    int updatePassword(@Param("id") String id,@Param("password") String password);

    List<Member> getMembersByAgentId(@Param("agentId") String agentId,@Param("keyword") String keyword,@Param("status") Integer status,@Param("pageId") Integer pageId);
}