package com.fr.lottery.dao;

import com.fr.lottery.entity.LimitSet;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LimitSetMapper {

    int deleteByUserId(@Param("userId") String userId);

    int insert(LimitSet record);

    List<LimitSet> selectByPrimaryKey(@Param("userId") String userId);
}