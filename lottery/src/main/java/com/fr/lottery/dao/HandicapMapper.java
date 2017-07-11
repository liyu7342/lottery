package com.fr.lottery.dao;

import com.fr.lottery.entity.Handicap;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface HandicapMapper {
    long countByExample(Handicap example);

    int deleteByPrimaryKey(String id);

    int insert(Handicap record);

    List<Handicap> selectByExample(Handicap example);

    Handicap selectByPrimaryKey(String id);

    int updateByPrimaryKey(Handicap record);
}