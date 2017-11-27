package com.fr.lottery.service.inter;

import com.fr.lottery.dto.BuhuoConfigDto;
import com.fr.lottery.entity.BucangConfig;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
public interface IBucangConfigService {
    List<BucangConfig> getDatas(String userId);
    BucangConfig get(String userId,String category,String gameType);
    void save(BuhuoConfigDto config  );
}
