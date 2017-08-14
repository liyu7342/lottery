package com.fr.lottery.service.impl;

import com.fr.lottery.dao.OddsMapper;
import com.fr.lottery.entity.Odds;
import com.fr.lottery.service.inter.IOddsService;
import com.fr.lottery.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    public List<Odds> selectDefault(String type) {
        String[] types = type.split("\\|");
        return oddsMapper.getTypeOddsList(types,true);

    }

    @Override
    public List<Odds> selectByType(String[] oddsType) {
        return oddsMapper.getTypeOddsList(oddsType,false);
    }

    public List<Odds> getOddsList(String[] oddsType,boolean isDefault){
        return oddsMapper.getTypeOddsList(oddsType,false);
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

    @Override
    public boolean insert(Map map) {

        boolean isDefault=false;
        if(map.containsKey("isDefault")){
            isDefault=Boolean.parseBoolean( map.get("isDefault").toString());
        }
        for(Object key :map.keySet()){
            if("isDefault".equals( key)){
                continue;
            }
            Odds odds = new Odds();
            odds.setIsdefault(isDefault);
            odds.setNumkey(key.toString());
            odds.setType(odds.getNumkey().substring(0,3));
            if(map.get(key) ==null || "".equals(map.get(key))){
                odds.setNumvalue(null);
            }else{

                String keyValue =map.get(key).toString();
                Float numvalue= Float.parseFloat(keyValue);
                odds.setNumvalue(numvalue);
            }
            Odds oddsEntity= oddsMapper.getOdds(odds.getType(),odds.getNumkey(),odds.getIsdefault());
            if(oddsEntity==null){
                odds.setId(StringUtil.getUUID());
                oddsMapper.insert(odds);
            }
            else{
                oddsEntity.setNumvalue(odds.getNumvalue());
                oddsMapper.updateByPrimaryKey(oddsEntity);
            }
        }
        return true;
    }
}
