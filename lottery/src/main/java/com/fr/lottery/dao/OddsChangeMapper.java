package com.fr.lottery.dao;

import com.fr.lottery.entity.Odds;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OddsChangeMapper {


    int insert(Odds record);

    List<Odds> getOddsChangesByType(@Param("oddSet") String oddset, @Param("types") String[] types);

    int updateByPrimaryKey(Odds record);
}