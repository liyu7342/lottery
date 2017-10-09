package com.fr.lottery.service.impl;

import com.fr.lottery.dao.HandicapMapper;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.opensaml.xml.signature.G;
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
        entity.setAutoopen(true);
        entity.setStatus(0);
        if(StringUtils.isBlank( entity.getId()) || entity.getId() ==null){
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
    public boolean openHandicap(Handicap handicap){
        return handicapMapper.openHandicap(handicap) >0;
    }

    @Override
    public List<Handicap> getHandicaps(Integer pageId) {
       if(pageId==null)
           pageId =1;
        Integer start = (pageId-1) * Global.pageSize;
        return  handicapMapper.findAll(start, Global.pageSize);
    }

    @Override
    public boolean delete(String id) {
        return handicapMapper.deleteByPrimaryKey(id)>0;
    }

    /**
     * 获取未结算的最新盘口
     * @return
     */
    @Override
    public Handicap getCurrentHandicap() {
        return handicapMapper.getCurrentHandicaps();
    }


    @Override
    public boolean settlement(String handicapId) {
        return false;
    }
}
