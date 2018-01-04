package com.fr.lottery.dao;

import com.fr.lottery.entity.Handicap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HandicapMapper {

    int deleteByPrimaryKey(String id);

    int insert(Handicap record);

    List<Handicap> selectByExample(Handicap example);

    List<Handicap> findAll(@Param("start") Integer start ,@Param("limit") Integer limit);

    Handicap selectByPrimaryKey(String id);

    Handicap getHandicapByRiqi(String riqi);

    int openHandicap(Handicap handicap);

    int updateByPrimaryKey(Handicap record);

    //Handicap getCurrentHandicaps();

    Handicap getLastestHandicap();

    Long count();
}