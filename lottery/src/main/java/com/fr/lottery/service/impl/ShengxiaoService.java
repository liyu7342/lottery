package com.fr.lottery.service.impl;

import com.fr.lottery.dao.ShengxiaoMapper;
import com.fr.lottery.entity.ShengXiao;
import com.fr.lottery.service.inter.IShengxiaoService;
import com.fr.lottery.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Liyu7342 on 2017-9-11.
 */
@Service
public class ShengxiaoService implements IShengxiaoService {
    @Autowired
    private ShengxiaoMapper shengxiaoMapper;

    @Override
    public List<ShengXiao> findByYear(int year) {
        return shengxiaoMapper.findByYear(year);
    }

    @Override
    public List<ShengXiao> findByYear() {
        Calendar date = Calendar.getInstance();

        return shengxiaoMapper.findByYear(date.get(Calendar.YEAR));
    }


    @Override
    public Map<String, String> findMapByYear() {
        List<ShengXiao> shengXiaos=  findByYear();
        Map<String,String> map = new HashMap<String, String>();
        for(ShengXiao shengXiao :shengXiaos){
            String strr=  shengXiao.getNo1()+","+shengXiao.getNo2()+","+shengXiao.getNo3()+","+shengXiao.getNo4();
            if(!StringUtil.isNullOrEmpty(shengXiao.getNo5())){
                strr+=","+shengXiao.getNo5();
            }
            map.put(shengXiao.getName(),strr);
        }
        return map;
    }

    @Override
    public Map<String, ShengXiao> findMapByYear1() {
        List<ShengXiao> shengXiaos=  findByYear();
        Map<String,ShengXiao> map = new HashMap<String, ShengXiao>();
        for(ShengXiao shengXiao :shengXiaos){
            map.put(shengXiao.getSortNo()>9?shengXiao.getSortNo().toString():"0"+shengXiao.getSortNo().toString(),shengXiao);
        }
        return map;
    }
}
