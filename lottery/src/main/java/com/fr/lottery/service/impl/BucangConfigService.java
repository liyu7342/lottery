package com.fr.lottery.service.impl;

import com.fr.lottery.dao.BucangConfigMapper;
import com.fr.lottery.dto.BuhuoConfigDto;
import com.fr.lottery.entity.BucangConfig;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.entity.User;
import com.fr.lottery.enums.GameTypeEnum;
import com.fr.lottery.service.inter.IBucangConfigService;
import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/27.
 */
@Service
public class BucangConfigService implements IBucangConfigService {
    @Autowired
    private BucangConfigMapper bucangConfigMapper;
    @Autowired
    private LimitSetService limitSetService;

    public List<BucangConfig> getDatas(String userId){
      List<BucangConfig> configs=  bucangConfigMapper.getDatas(userId);
        if(configs.size()==0){
          List<LimitSet> limitSets= limitSetService.findAll(userId);
            for(LimitSet limitSet : limitSets){
                if(GameTypeEnum.連碼三.getValue().equals(limitSet.getLimitType())){
                    BucangConfig config=new BucangConfig();
                    config.setCategory( limitSet.getLimitType());
                    config.setGameType("011");
                    config.setBaseAmount( limitSet.getSinglehighest());
                    config.setFlagValue(1);
                    configs.add(config);

                    BucangConfig config1=new BucangConfig();
                    config1.setCategory( limitSet.getLimitType());
                    config1.setGameType("012");
                    config1.setBaseAmount( limitSet.getSinglehighest());
                    config1.setFlagValue(1);
                    configs.add(config1);
                }

                else{
                    BucangConfig config=new BucangConfig();
                    if("A00".equals(limitSet.getLimitType())){
                        config.setCategory( GameTypeEnum.特码.getValue());
                    }
                    else
                        config.setCategory( limitSet.getLimitType());
                    config.setGameType("");
                    config.setBaseAmount( limitSet.getSinglehighest());
                    config.setFlagValue(1);
                    configs.add(config);
                }

                //config.setGameType(limitSet.);
            }
        }
        return configs;
    }

    public BucangConfig get(String userId,String category,String gameType){
        return bucangConfigMapper.getBuCangConfig(userId,category,gameType);
    }

    public void save(BuhuoConfigDto configDto  ){
        User user = UserHelper.getCurrentUser();
        bucangConfigMapper.deleteByUserId(user.getId());
        BucangConfig config1= new BucangConfig("00","",configDto.getBase_00_(),configDto.getFlag_00_(),user.getId());
        BucangConfig config2 = new BucangConfig("01","",configDto.getBase_01_(),configDto.getFlag_01_(),user.getId());
        BucangConfig config3= new BucangConfig("02","",configDto.getBase_02_(),configDto.getFlag_02_(),user.getId());
        BucangConfig config4 = new BucangConfig("03","",configDto.getBase_03_(),configDto.getFlag_03_(),user.getId());
        BucangConfig config5= new BucangConfig("04","011",configDto.getBase_04_011(),configDto.getFlag_04_011(),user.getId());

        BucangConfig config6 = new BucangConfig("04","012",configDto.getBase_04_012(),configDto.getFlag_04_012(),user.getId());
        BucangConfig config7= new BucangConfig("05","",configDto.getBase_05_(),configDto.getFlag_05_(),user.getId());
        BucangConfig config8 = new BucangConfig("06","",configDto.getBase_06_(),configDto.getFlag_06_(),user.getId());
        BucangConfig config9= new BucangConfig("07","",configDto.getBase_07_(),configDto.getFlag_07_(),user.getId());
        BucangConfig config10 = new BucangConfig("08","",configDto.getBase_08_(),configDto.getFlag_08_(),user.getId());
        BucangConfig config11= new BucangConfig("09","",configDto.getBase_09_(),configDto.getFlag_09_(),user.getId());
        BucangConfig config12 = new BucangConfig("10","",configDto.getBase_10_(),configDto.getFlag_10_(),user.getId());
        BucangConfig config13= new BucangConfig("11","",configDto.getBase_11_(),configDto.getFlag_11_(),user.getId());
        BucangConfig config14 = new BucangConfig("12","",configDto.getBase_12_(),configDto.getFlag_12_(),user.getId());
        BucangConfig config15= new BucangConfig("13","",configDto.getBase_13_(),configDto.getFlag_13_(),user.getId());
        BucangConfig config16 = new BucangConfig("14","",configDto.getBase_14_(),configDto.getFlag_14_(),user.getId());
        BucangConfig config17= new BucangConfig("15","",configDto.getBase_15_(),configDto.getFlag_15_(),user.getId());
        bucangConfigMapper.insert(config1);
        bucangConfigMapper.insert(config2);
        bucangConfigMapper.insert(config3);
        bucangConfigMapper.insert(config4);
        bucangConfigMapper.insert(config5);
        bucangConfigMapper.insert(config6);
        bucangConfigMapper.insert(config7);
        bucangConfigMapper.insert(config8);
        bucangConfigMapper.insert(config9);
        bucangConfigMapper.insert(config10);
        bucangConfigMapper.insert(config11);
        bucangConfigMapper.insert(config12);
        bucangConfigMapper.insert(config13);
        bucangConfigMapper.insert(config14);
        bucangConfigMapper.insert(config15);
        bucangConfigMapper.insert(config16);
        bucangConfigMapper.insert(config17);

    }
}
