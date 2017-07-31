package com.yunfang.inquiry.dao1;

import com.yunfang.inquiry.entity1.Handicap;
import com.yunfang.inquiry.entity1.HandicapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HandicapMapper {
    long countByExample(HandicapExample example);

    int deleteByExample(HandicapExample example);

    int deleteByPrimaryKey(String id);

    int insert(Handicap record);

    int insertSelective(Handicap record);

    List<Handicap> selectByExample(HandicapExample example);

    Handicap selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Handicap record, @Param("example") HandicapExample example);

    int updateByExample(@Param("record") Handicap record, @Param("example") HandicapExample example);

    int updateByPrimaryKeySelective(Handicap record);

    int updateByPrimaryKey(Handicap record);
}