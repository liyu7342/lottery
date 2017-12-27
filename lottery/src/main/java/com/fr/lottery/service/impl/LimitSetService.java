package com.fr.lottery.service.impl;

import com.fr.lottery.dao.LimitSetMapper;
import com.fr.lottery.dto.LimitSetDto;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.service.inter.ILimitSetService;
import com.fr.lottery.utils.MemcacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/17.
 */
@Service
public class LimitSetService  implements ILimitSetService{
    private static  final  String memcache_key="limit_";
    @Autowired
    private LimitSetMapper limitSetMapper;


    @Override
    public List<LimitSet> findAll(String userId) {
       return  limitSetMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<LimitSet> getByCategory(String userId,String categoryId){
        return limitSetMapper.getByCategory(userId,categoryId);
    }

    @Override
    public boolean insert(List<LimitSet> limitSets) {

        for(LimitSet limitSet: limitSets){
            limitSetMapper.insert(limitSet);
        }
        return true;
    }

    public boolean delete(String userId){
        limitSetMapper.deleteByUserId(userId);
        return true;
    }

    @Override
    @Transactional
    public boolean insert(String userId, LimitSetDto limitSetDto) {
        limitSetMapper.deleteByUserId(userId);
        LimitSet limitSet0 = new LimitSet(userId,"A" + GameTypeEnum.特码.getValue() ,limitSetDto.getOrdermin0(),
                limitSetDto.getOrdermax0(),limitSetDto.getItemmax0(),limitSetDto.getDiscountAA00(),limitSetDto.getDiscountBA00(),limitSetDto.getDiscountCA00());
        limitSetMapper.insert(limitSet0);
        LimitSet limitSet01 = new LimitSet(userId,"B" + GameTypeEnum.特码.getValue(),limitSetDto.getOrdermin0(),
                limitSetDto.getOrdermax0(),limitSetDto.getItemmax0(),limitSetDto.getDiscountAB00(),limitSetDto.getDiscountBB00(),limitSetDto.getDiscountCB00());
        limitSetMapper.insert(limitSet01);
        LimitSet limitSet1 = new LimitSet(userId,GameTypeEnum.正码.getValue(),limitSetDto.getOrdermin0(),
                limitSetDto.getOrdermax1(),limitSetDto.getItemmax1(),limitSetDto.getDiscountA1(),limitSetDto.getDiscountB1(),limitSetDto.getDiscountC1());
        limitSetMapper.insert(limitSet1);
        LimitSet limitSet2 = new LimitSet(userId,GameTypeEnum.正码特.getValue(),limitSetDto.getOrdermin2(),
                limitSetDto.getOrdermax2(),limitSetDto.getItemmax2(),limitSetDto.getDiscountA2(),limitSetDto.getDiscountB2(),limitSetDto.getDiscountC2());
        limitSetMapper.insert(limitSet2);
        LimitSet limitSet3 = new LimitSet(userId,GameTypeEnum.連碼二.getValue(),limitSetDto.getOrdermin3(),
                limitSetDto.getOrdermax3(),limitSetDto.getItemmax3(),limitSetDto.getDiscountA3(),limitSetDto.getDiscountB3(),limitSetDto.getDiscountC3());
        limitSetMapper.insert(limitSet3);
        LimitSet limitSet4 = new LimitSet(userId,GameTypeEnum.連碼三.getValue(),limitSetDto.getOrdermin4(),
                limitSetDto.getOrdermax4(),limitSetDto.getItemmax4(),limitSetDto.getDiscountA4(),limitSetDto.getDiscountB4(),limitSetDto.getDiscountC4());
        limitSetMapper.insert(limitSet4);
        LimitSet limitSet5 = new LimitSet(userId,GameTypeEnum.過關.getValue(),limitSetDto.getOrdermin5(),
                limitSetDto.getOrdermax5(),limitSetDto.getItemmax5(),limitSetDto.getDiscountA5(),limitSetDto.getDiscountB5(),limitSetDto.getDiscountC5());
        limitSetMapper.insert(limitSet5);
        LimitSet limitSet6 = new LimitSet(userId,GameTypeEnum.生肖.getValue(),limitSetDto.getOrdermin6(),
                limitSetDto.getOrdermax6(),limitSetDto.getItemmax6(),limitSetDto.getDiscountA6(),limitSetDto.getDiscountB6(),limitSetDto.getDiscountC6());
        limitSetMapper.insert(limitSet6);
        LimitSet limitSet7 = new LimitSet(userId,GameTypeEnum.尾數.getValue(),limitSetDto.getOrdermin7(),
                limitSetDto.getOrdermax7(),limitSetDto.getItemmax7(),limitSetDto.getDiscountA7(),limitSetDto.getDiscountB7(),limitSetDto.getDiscountC7());
        limitSetMapper.insert(limitSet7);
        LimitSet limitSet8 = new LimitSet(userId,GameTypeEnum.半波.getValue(),limitSetDto.getOrdermin8(),
                limitSetDto.getOrdermax8(),limitSetDto.getItemmax8(),limitSetDto.getDiscountA8(),limitSetDto.getDiscountB8(),limitSetDto.getDiscountC8());
        limitSetMapper.insert(limitSet8);
        LimitSet limitSet9 = new LimitSet(userId,GameTypeEnum.六肖.getValue(),limitSetDto.getOrdermin9(),
                limitSetDto.getOrdermax9(),limitSetDto.getItemmax9(),limitSetDto.getDiscountA9(),limitSetDto.getDiscountB9(),limitSetDto.getDiscountC9());
        limitSetMapper.insert(limitSet9);
        LimitSet limitSet10 = new LimitSet(userId,GameTypeEnum.兩面.getValue(),limitSetDto.getOrdermin10(),
                limitSetDto.getOrdermax10(),limitSetDto.getItemmax10(),limitSetDto.getDiscountA10(),limitSetDto.getDiscountB10(),limitSetDto.getDiscountC10());
        limitSetMapper.insert(limitSet10);
        LimitSet limitSet11 = new LimitSet(userId,GameTypeEnum.色波.getValue(),limitSetDto.getOrdermin11(),
                limitSetDto.getOrdermax11(),limitSetDto.getItemmax11(),limitSetDto.getDiscountA11(),limitSetDto.getDiscountB11(),limitSetDto.getDiscountC11());
        limitSetMapper.insert(limitSet11);
        LimitSet limitSet12 = new LimitSet(userId,GameTypeEnum.特肖.getValue(),limitSetDto.getOrdermin12(),
                limitSetDto.getOrdermax12(),limitSetDto.getItemmax12(),limitSetDto.getDiscountA12(),limitSetDto.getDiscountB12(),limitSetDto.getDiscountC12());
        limitSetMapper.insert(limitSet12);
        LimitSet limitSet13 = new LimitSet(userId,GameTypeEnum.生肖連.getValue(),limitSetDto.getOrdermin13(),
                limitSetDto.getOrdermax13(),limitSetDto.getItemmax13(),limitSetDto.getDiscountA13(),limitSetDto.getDiscountB13(),limitSetDto.getDiscountC13());
        limitSetMapper.insert(limitSet13);
        LimitSet limitSet14 = new LimitSet(userId,GameTypeEnum.尾數連.getValue(),limitSetDto.getOrdermin14(),
                limitSetDto.getOrdermax14(),limitSetDto.getItemmax14(),limitSetDto.getDiscountA14(),limitSetDto.getDiscountB14(),limitSetDto.getDiscountC14());
        limitSetMapper.insert(limitSet14);
        LimitSet limitSet15 = new LimitSet(userId,GameTypeEnum.不中.getValue(),limitSetDto.getOrdermin15(),
                limitSetDto.getOrdermax15(),limitSetDto.getItemmax15(),limitSetDto.getDiscountA15(),limitSetDto.getDiscountB15(),limitSetDto.getDiscountC15());
        limitSetMapper.insert(limitSet15);
        return true;
    }

    /**
     *
     * @param userId
     * @param odd_set 下单盘口
     * @param limitType
     * @param handicapStr 用户所在盘口
     * @return
     */
    @Override
    public Float findRetreatFromCache(String userId,String odd_set,String limitType,String handicapStr){
        String key = limitType;
        Float result=0f;
        if(GameTypeEnum.特码.getValue().equals(limitType) && odd_set.length()>1){
            key=odd_set.substring(1)+limitType;
        }
        Object obj =  MemcacheUtil.get(memcache_key+key+"_"+userId);
        if(obj==null){
            List<LimitSet> limitSets= limitSetMapper.selectByPrimaryKey(userId);
            for(LimitSet limitSet:limitSets){

                Float retreat =  "A".equals( handicapStr)? limitSet.getaRetreat():("B".equals(handicapStr)?limitSet.getbRetreat():limitSet.getcRetreat());
                if(limitSet.getLimitType().equals(key)){
                    result=retreat;
                }
                MemcacheUtil.add(memcache_key+limitSet.getLimitType()+"_"+userId,retreat);
            }
            return result;
        }
        result = (Float)obj;
        return result;
    }

}
