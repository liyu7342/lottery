package com.fr.lottery.service.impl;

import com.fr.lottery.dao.BucangConfigMapper;
import com.fr.lottery.entity.BucangConfig;
import com.fr.lottery.entity.LimitSet;
import com.fr.lottery.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
@Service
public class BucangConfigService {
    @Autowired
    private BucangConfigMapper bucangConfigMapper;
    @Autowired
    private LimitSetService limitSetService;

    public List<BucangConfig> getDatas(String userId){
      List<BucangConfig> configs=  bucangConfigMapper.getDatas(userId);
        if(configs.size()==0){
          List<LimitSet> limitSets= limitSetService.findAll(userId);
            for(LimitSet limitSet : limitSets){
                BucangConfig config=new BucangConfig();
                config.setCategory( limitSet.getLimitType());
                config.setBaseAmount( limitSet.getSinglehighest());
                config.setFlagValue(1);
                //config.setGameType(limitSet.);
            }
        }
    }

    public BucangConfig get(String userId,String category,String gameType){
        return bucangConfigMapper.getBuCangConfig(userId,category,gameType);
    }

    public void save(BucangConfig config  ){
        if(StringUtils.isNotBlank(config.getId())){
            config.setId(StringUtil.getUUID());
            bucangConfigMapper.insert(config);
        }
        else{
            bucangConfigMapper.update(config);
        }
    }
}
