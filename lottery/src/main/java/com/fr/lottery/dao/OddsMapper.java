package com.fr.lottery.dao;

import java.util.List;

import com.fr.lottery.entity.Odds;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OddsMapper {
    long countByExample(Odds entity);

    int deleteByPrimaryKey(String id);

    int insert(Odds record);

    List<Odds> selectByExample(Odds entity);

    Odds get(@Param("type") String type, @Param("type") Boolean isDefault);

    Odds selectByPrimaryKey(String id);

    int updateByPrimaryKey(Odds record);
}