package com.fr.lottery.utils;

import com.fr.lottery.entity.LotConfig;
import com.fr.lottery.service.inter.ILotConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Liyu7342 on 2017-9-9.
 */
@Component
public class LotConfigHelper {
    @Autowired
    private ILotConfigService lotConfigService;

    private static LotConfigHelper lotConfigHelper;

    @PostConstruct
    public void init(){
        lotConfigHelper=this;
        lotConfigHelper.lotConfigService = this.lotConfigService;
    }

    public static List<LotConfig> findAll(){
        return lotConfigHelper.lotConfigService.findAll();
    }
}
