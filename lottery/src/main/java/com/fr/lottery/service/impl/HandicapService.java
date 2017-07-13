package com.fr.lottery.service.impl;

import com.fr.lottery.dao.HandicapMapper;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */
@Service
public class HandicapService implements IHandicapService {

    @Autowired
    private HandicapMapper handicapMapper;
    @Override
    public boolean save(Handicap entity) {
        if(StringUtils.isNotBlank( entity.getId())){
            entity.setId(StringUtil.getUUID());
            return handicapMapper.insert(entity)>0;
        }
        return handicapMapper.updateByPrimaryKey(entity)>0;
    }

    @Override
    public Handicap selectByPrimaryKey(String id) {
        return  handicapMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Handicap> getHandicaps() {
       return  handicapMapper.selectByExample(new Handicap());
    }

    @Override
    public boolean delete(String id) {
        return handicapMapper.deleteByPrimaryKey(id)>0;
    }
}
