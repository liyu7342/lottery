package com.fr.lottery.service.impl;

import com.fr.lottery.dao.LimitSetMapper;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.service.inter.ILimitSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
@Service
public class LimitSetService  implements ILimitSetService{
    @Autowired
    private LimitSetMapper limitSetMapper;


    @Override
    public List<LimitSet> findAll(String reftable, String refrecordId) {
       return  limitSetMapper.selectByPrimaryKey(reftable,refrecordId);
    }

    @Override
    public boolean insert(List<LimitSet> limitSets) {

        for(LimitSet limitSet: limitSets){
            limitSetMapper.insert(limitSet);
        }
        return true;
    }

    public boolean delete(String reftable,String refrecordId){
        limitSetMapper.deleteByPrimaryKey(reftable,refrecordId);
        return true;
    }
}
