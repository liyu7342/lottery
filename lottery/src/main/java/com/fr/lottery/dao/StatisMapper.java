package com.fr.lottery.dao;

import com.fr.lottery.condition.StatisCondition;
import com.fr.lottery.dto.StatisDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Liyu7342 on 2017-9-17.
 */
@Repository
public interface StatisMapper {
    List<StatisDto> getStatis(@Param("gameTypes") String[] gameTypes,@Param("handicapId") String handicapId,@Param("xpath") String xpath);

    List<StatisDto> getStatisByCallable(StatisCondition condition);

    List<StatisDto> getStatisZhengmaByCallable(StatisCondition condition);


    List<StatisDto> getStatisLianma(StatisCondition condition);

    StatisDto getStatisLianmaCount(StatisCondition condition);

    List<Map>  get_statics_data(StatisCondition condition);
}
