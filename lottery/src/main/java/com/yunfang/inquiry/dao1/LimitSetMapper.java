package com.yunfang.inquiry.dao1;

import com.yunfang.inquiry.entity1.LimitSet;
import com.yunfang.inquiry.entity1.LimitSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LimitSetMapper {
    long countByExample(LimitSetExample example);

    int deleteByExample(LimitSetExample example);

    int deleteByPrimaryKey(String id);

    int insert(LimitSet record);

    int insertSelective(LimitSet record);

    List<LimitSet> selectByExample(LimitSetExample example);

    LimitSet selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LimitSet record, @Param("example") LimitSetExample example);

    int updateByExample(@Param("record") LimitSet record, @Param("example") LimitSetExample example);

    int updateByPrimaryKeySelective(LimitSet record);

    int updateByPrimaryKey(LimitSet record);
}