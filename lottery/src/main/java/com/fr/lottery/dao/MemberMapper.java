package com.fr.lottery.dao;

import com.fr.lottery.entity.Member; 
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {
    long countByExample(Member example);

    int deleteByPrimaryKey(String id);

    int insert(Member record);

    List<Member> selectByExample(Member example);

    Member selectByPrimaryKey(String id);


    int updateByPrimaryKey(Member record);
}