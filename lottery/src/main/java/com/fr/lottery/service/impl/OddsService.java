package com.fr.lottery.service.impl;

import com.fr.lottery.dao.OddsMapper;
import com.fr.lottery.entity.Odds;
import com.fr.lottery.service.inter.IOddsService;
import com.fr.lottery.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-7-10.
 * 赔率
 */
@Service
public class OddsService implements IOddsService{

    @Autowired
    private OddsMapper oddsMapper;
    @Override
    public Odds selectByPrimaryKey(String id) {
        return oddsMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteByPrimaryKey(String id) {
        return oddsMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Odds selectDefault(String type) {
        return oddsMapper.get(type,true);

    }

    @Override
    public Odds selectByType(String type) {
        return oddsMapper.get(type,false);
    }

    @Override
    public boolean update(Odds entity) {
       return oddsMapper.updateByPrimaryKey(entity)>0;
    }

    @Override
    public boolean insert(Odds entity) {
        entity.setId(StringUtil.getUUID());
        return oddsMapper.insert(entity)>0;
    }
}
