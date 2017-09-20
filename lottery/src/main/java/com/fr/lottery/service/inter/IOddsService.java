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

    /**
     * 默认赔率
     * @return
     */
    List<Odds> selectDefault(String type);

    /**
     *
     * @param oddsType 类型
     * @return
     */
    List<Odds> selectByType(String[] oddsType);

    List<Odds> getOddsList(String[] oddsType,boolean isDefault);

    Map<String,Float> getOddsMap(String[] oddsType);

    boolean update(Odds entity);

    boolean insert (Odds entity);
}
