package com.fr.lottery.service.impl;

import com.fr.lottery.dao.OddsMapper;
import com.fr.lottery.entity.Handicap;
import com.fr.lottery.entity.Odds;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.IOddsService;
import com.fr.lottery.utils.DateTimeUtils;
import com.fr.lottery.utils.StringUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
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

    @Autowired
    private IHandicapService handicapService;

    @Override
    public Odds selectByPrimaryKey(String id) {
        return oddsMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteByPrimaryKey(String id) {
        return oddsMapper.deleteByPrimaryKey(id)>0;
    }




    @Override
    public Map<String, String> getOddsMap(String oddSet,String[] oddsType) {
        List<Odds> oddsList = oddsMapper.getTypeOddsList(oddSet,oddsType,false);
        Map<String,String> map = new HashedMap();
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue()==null?"":odds.getNumvalue().toString());
        }
        return map;
    }

    @Override
    public List<Odds> getOddsChange(String oddSet, String[] oddsType) {
        List<Odds> oddsList=oddsMapper.getTypeOddsList(oddSet,oddsType,false);
        boolean isOpen =handicapService.IsOpenHandicap();
        if(!isOpen){
            for(Odds odds :oddsList){
                odds.setNumvalue(null);
            }
        }
        return oddsList;
    }

    @Override
    public Map<String, String> getOddsChangeMap(String[] oddsType) {
        return getOddsChangeMap("",oddsType);
    }
    @Override
    public Map<String, String> getOddsChangeMap(String oddSet,String[] oddsType) {
        List<Odds> oddsList = oddsMapper.getTypeOddsList(oddSet,oddsType,false);
        boolean isOpen =handicapService.IsOpenHandicap();
        Map<String,String> map = new HashedMap();
        if(isOpen) {
            for (Odds odds : oddsList) {
                map.put("pro_" + odds.getNumkey(),odds.getNumvalue()==null?"": odds.getNumvalue().toString());
            }
        }
        else{
            for (Odds odds : oddsList) {
                map.put("pro_" + odds.getNumkey(), "");
            }
        }
        return map;
    }
    @Override
    public List<Odds> getOddsList(String oddSet, String[] oddsType) {
        return oddsMapper.getTypeOddsList(oddSet,oddsType,false);
    }



    @Override
    public Map<String, String> getOddsMap(String[] oddsType) {
        return getOddsMap("",oddsType);
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
        String oddSet="";
        if(map.containsKey("isDefault")){
            isDefault=Boolean.parseBoolean( map.get("isDefault").toString());
            map.remove("isDefault");
        }
        if(map.containsKey("oddSet")){
            oddSet= map.get("oddSet").toString();
            map.remove("oddSet");
        }

        for(Object key :map.keySet()){
            Odds odds = new Odds();
            odds.setIsdefault(isDefault);
            if(StringUtils.isNotBlank(oddSet)){
                odds.setOddSet(oddSet);
            }
            odds.setNumkey(key.toString());
            odds.setType(odds.getNumkey().substring(0,3));
            if(map.get(key) ==null || "".equals(map.get(key))){
                odds.setNumvalue(null);
            }else{

                String keyValue =map.get(key).toString();
                Float numvalue= Float.parseFloat(keyValue);
                odds.setNumvalue(numvalue);
            }
            Odds oddsEntity= oddsMapper.getOdds(oddSet,odds.getType(),odds.getNumkey(),odds.getIsdefault());
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
