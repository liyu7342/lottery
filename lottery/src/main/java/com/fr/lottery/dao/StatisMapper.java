package com.fr.lottery.dao;

import com.fr.lottery.dto.StatisDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-9-17.
 */
@Repository
public interface StatisMapper {
    List<StatisDto> getStatis(@Param("gameTypes") String[] gameTypes,@Param("handicapId") String handicapId,@Param("xpath") String xpath);
}
