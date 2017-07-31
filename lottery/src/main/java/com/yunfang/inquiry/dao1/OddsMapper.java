package com.yunfang.inquiry.dao1;

import com.yunfang.inquiry.entity1.Odds;
import com.yunfang.inquiry.entity1.OddsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OddsMapper {
    long countByExample(OddsExample example);

    int deleteByExample(OddsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Odds record);

    int insertSelective(Odds record);

    List<Odds> selectByExample(OddsExample example);

    Odds selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Odds record, @Param("example") OddsExample example);

    int updateByExample(@Param("record") Odds record, @Param("example") OddsExample example);

    int updateByPrimaryKeySelective(Odds record);

    int updateByPrimaryKey(Odds record);
}