package com.fr.lottery.service.impl;

import com.fr.lottery.dao.OddsChangeMapper;
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

    @Autowired
    private OddsChangeMapper oddsChangeMapper;

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
        Map<String,String> map = new HashedMap();
        List<Odds> oddsList = getOddsChange(oddSet,oddsType);
        for(Odds odds : oddsList){
            map.put("pro_"+odds.getNumkey(),odds.getNumvalue()==null?"":odds.getNumvalue().toString());
        }
        return map;
    }

    @Override
    public List<Odds> getOddsChange(String oddSet, String[] oddsType) {
        if(oddSet.length()==2){

        }
        List<Odds> oddsList=getOddsList(oddSet,oddsType);
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

    /***
     * 赔率变动，封盘时变为空，开盘时获取初始值
     * @param oddSet
     * @param oddsType
     * @return
     */
    @Override
    public Map<String, String> getOddsChangeMap(String oddSet,String[] oddsType) {
        boolean isOpen =handicapService.IsOpenHandicap();
        Map<String,String> map = new HashedMap();
        if(isOpen) {
            List<Odds> oddsList = oddsChangeMapper.getOddsChangesByType(oddSet,oddsType);
            for (Odds odds : oddsList) {
                map.put("pro_" + odds.getNumkey(),odds.getNumvalue()==null?"": odds.getNumvalue().toString());
            }
        }
        else{
            List<Odds> oddsList = oddsMapper.getTypeOddsList(oddSet,oddsType,false);
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
    public List<Odds> getOddsList(String[] oddsType){
        return oddsMapper.getOddsList("",oddsType,false);
    }

    public List<Odds> getOddsListByNumkey(String oddsType,String numkey){
        if(numkey.contains(",")){
            String[] keys= numkey.split(",");
            String[] keyArr = new String[keys.length];
            int i=0;
            for(String key :keys){
                keyArr[i++] = oddsType +key ;
            }
            return oddsMapper.getOddsByNumKeys(oddsType,keyArr);

        }
        else
            return oddsMapper.getOddsByNumKey(oddsType,oddsType+numkey);
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
            if(odds.getType().equals("019") || odds.getType().equals("027")){
                odds.setOddSet(oddSet.substring(0,1));
            }

            Odds oddsEntity= oddsMapper.getOdds(odds.getOddSet(),odds.getType(),odds.getNumkey(),odds.getIsdefault());
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
