package com.fr.lottery.service.inter;

import com.fr.lottery.entity.LimitSet;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
public interface ILimitSetService {
    List<LimitSet>   findAll(String userId);

    boolean insert(List<LimitSet> limitSets);

    boolean delete(String reftable,String refrecordId);

}
