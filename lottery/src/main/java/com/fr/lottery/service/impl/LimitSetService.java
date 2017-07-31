package com.fr.lottery.service.impl;

import com.fr.lottery.dao.LimitSetMapper;
import com.fr.lottery.dto.LimitSetDto;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.service.inter.ILimitSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */
@Service
public class LimitSetService  implements ILimitSetService{
    @Autowired
    private LimitSetMapper limitSetMapper;


    @Override
    public List<LimitSet> findAll(String userId) {
       return  limitSetMapper.selectByPrimaryKey(userId);
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
        LimitSet limitSet0 = new LimitSet(userId,GameTypeEnum.特码,limitSetDto.getOrdermin0(),
                limitSetDto.getOrdermax0(),limitSetDto.getItemmax0(),limitSetDto.getDiscountA0(),limitSetDto.getDiscountB0(),limitSetDto.getDiscountC0());
        limitSetMapper.insert(limitSet0);
        LimitSet limitSet1 = new LimitSet(userId,GameTypeEnum.正码,limitSetDto.getOrdermin0(),
                limitSetDto.getOrdermax1(),limitSetDto.getItemmax1(),limitSetDto.getDiscountA1(),limitSetDto.getDiscountB1(),limitSetDto.getDiscountC1());
        limitSetMapper.insert(limitSet1);
        LimitSet limitSet2 = new LimitSet(userId,GameTypeEnum.正码特,limitSetDto.getOrdermin2(),
                limitSetDto.getOrdermax2(),limitSetDto.getItemmax2(),limitSetDto.getDiscountA2(),limitSetDto.getDiscountB2(),limitSetDto.getDiscountC2());
        limitSetMapper.insert(limitSet2);
        LimitSet limitSet3 = new LimitSet(userId,GameTypeEnum.連碼二,limitSetDto.getOrdermin3(),
                limitSetDto.getOrdermax3(),limitSetDto.getItemmax3(),limitSetDto.getDiscountA3(),limitSetDto.getDiscountB3(),limitSetDto.getDiscountC3());
        limitSetMapper.insert(limitSet3);
        LimitSet limitSet4 = new LimitSet(userId,GameTypeEnum.連碼三,limitSetDto.getOrdermin4(),
                limitSetDto.getOrdermax4(),limitSetDto.getItemmax4(),limitSetDto.getDiscountA4(),limitSetDto.getDiscountB4(),limitSetDto.getDiscountC4());
        limitSetMapper.insert(limitSet4);
        LimitSet limitSet5 = new LimitSet(userId,GameTypeEnum.過關,limitSetDto.getOrdermin5(),
                limitSetDto.getOrdermax5(),limitSetDto.getItemmax5(),limitSetDto.getDiscountA5(),limitSetDto.getDiscountB5(),limitSetDto.getDiscountC5());
        limitSetMapper.insert(limitSet5);
        LimitSet limitSet6 = new LimitSet(userId,GameTypeEnum.生肖,limitSetDto.getOrdermin6(),
                limitSetDto.getOrdermax6(),limitSetDto.getItemmax6(),limitSetDto.getDiscountA6(),limitSetDto.getDiscountB6(),limitSetDto.getDiscountC6());
        limitSetMapper.insert(limitSet6);
        LimitSet limitSet7 = new LimitSet(userId,GameTypeEnum.尾數,limitSetDto.getOrdermin7(),
                limitSetDto.getOrdermax7(),limitSetDto.getItemmax7(),limitSetDto.getDiscountA7(),limitSetDto.getDiscountB7(),limitSetDto.getDiscountC7());
        limitSetMapper.insert(limitSet7);
        LimitSet limitSet8 = new LimitSet(userId,GameTypeEnum.半波,limitSetDto.getOrdermin8(),
                limitSetDto.getOrdermax8(),limitSetDto.getItemmax8(),limitSetDto.getDiscountA8(),limitSetDto.getDiscountB8(),limitSetDto.getDiscountC8());
        limitSetMapper.insert(limitSet8);
        LimitSet limitSet9 = new LimitSet(userId,GameTypeEnum.六肖,limitSetDto.getOrdermin9(),
                limitSetDto.getOrdermax9(),limitSetDto.getItemmax9(),limitSetDto.getDiscountA9(),limitSetDto.getDiscountB9(),limitSetDto.getDiscountC9());
        limitSetMapper.insert(limitSet9);
        LimitSet limitSet10 = new LimitSet(userId,GameTypeEnum.兩面,limitSetDto.getOrdermin10(),
                limitSetDto.getOrdermax10(),limitSetDto.getItemmax10(),limitSetDto.getDiscountA10(),limitSetDto.getDiscountB10(),limitSetDto.getDiscountC10());
        limitSetMapper.insert(limitSet10);
        LimitSet limitSet11 = new LimitSet(userId,GameTypeEnum.色波,limitSetDto.getOrdermin11(),
                limitSetDto.getOrdermax11(),limitSetDto.getItemmax11(),limitSetDto.getDiscountA11(),limitSetDto.getDiscountB11(),limitSetDto.getDiscountC11());
        limitSetMapper.insert(limitSet11);
        LimitSet limitSet12 = new LimitSet(userId,GameTypeEnum.特肖,limitSetDto.getOrdermin12(),
                limitSetDto.getOrdermax12(),limitSetDto.getItemmax12(),limitSetDto.getDiscountA12(),limitSetDto.getDiscountB12(),limitSetDto.getDiscountC12());
        limitSetMapper.insert(limitSet12);
        LimitSet limitSet13 = new LimitSet(userId,GameTypeEnum.生肖連,limitSetDto.getOrdermin13(),
                limitSetDto.getOrdermax13(),limitSetDto.getItemmax13(),limitSetDto.getDiscountA13(),limitSetDto.getDiscountB13(),limitSetDto.getDiscountC13());
        limitSetMapper.insert(limitSet13);
        LimitSet limitSet14 = new LimitSet(userId,GameTypeEnum.尾數連,limitSetDto.getOrdermin14(),
                limitSetDto.getOrdermax14(),limitSetDto.getItemmax14(),limitSetDto.getDiscountA14(),limitSetDto.getDiscountB14(),limitSetDto.getDiscountC14());
        limitSetMapper.insert(limitSet14);
        LimitSet limitSet15 = new LimitSet(userId,GameTypeEnum.不中,limitSetDto.getOrdermin15(),
                limitSetDto.getOrdermax15(),limitSetDto.getItemmax15(),limitSetDto.getDiscountA15(),limitSetDto.getDiscountB15(),limitSetDto.getDiscountC15());
        limitSetMapper.insert(limitSet15);
        return true;
    }

}
