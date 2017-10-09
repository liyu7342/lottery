package com.fr.lottery.service.inter;

import com.fr.lottery.entity.Odds;

import java.util.List;
import java.util.Map;

/**
 * Created by Liyu7342 on 2017-7-10.
 * 赔率设置
 */
public interface IOddsService {

    /**
     * 获取赔率
     * @param id
     * @return
     */
    Odds selectByPrimaryKey( String id);

    boolean insert (Map map);
    /**
     * 赔率删除
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(String id);


    Map<String,Float> getOddsMap(String[] oddsType);

    Map<String,Float> getOddsMap(String oddSet,String[] oddsType);

    List<Odds> getOddsChange(String oddSet,String[] oddsType);

    List<Odds> getOddsList(String oddSet,String[] oddsType);

    boolean update(Odds entity);

    boolean insert (Odds entity);
}
