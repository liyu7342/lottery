package com.fr.lottery.dao;

import com.fr.lottery.entity.LimitSet;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LimitSetMapper {

    int deleteByPrimaryKey(@Param("reftable") String reftable,@Param("refrecordId") String refrecordId);

    int insert(LimitSet record);

    List<LimitSet> selectByPrimaryKey(@Param("userId") String userId);
}