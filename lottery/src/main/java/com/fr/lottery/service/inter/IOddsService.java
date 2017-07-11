package com.fr.lottery.service.inter;

import com.fr.lottery.entity.Odds;

import java.util.List;

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
    Odds selectDefault(String type);

    /**
     *
     * @param type 类型
     * @return
     */
    Odds selectByType(String type);

    boolean update(Odds entity);

    boolean insert (Odds entity);
}
