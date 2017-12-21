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

    List<Odds> getTypeOdds(@Param("type") String type, @Param("isDefault") Boolean isDefault);

    //
    List<Odds> getTypeOddsList(@Param("oddSet") String oddset,@Param("types") String[] types, @Param("isDefault") Boolean isDefault);

    List<Odds> getOddsByNumKey(@Param("type") String gameType,@Param("numkey") String numkey);
    List<Odds> getOddsByNumKeys(@Param("type") String gameType,@Param("numkeys") String[] numkeys);

    Odds getOdds(@Param("oddSet") String oddset,@Param("type")String type,@Param("numkey") String numkey,@Param("isDefault") Boolean isDefault);

    Odds selectByPrimaryKey(String id);

    int updateByPrimaryKey(Odds record);
}