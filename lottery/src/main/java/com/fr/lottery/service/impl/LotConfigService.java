package com.fr.lottery.service.impl;

import com.fr.lottery.dao.LotConfigMapper;
import com.fr.lottery.entity.LotConfig;
import com.fr.lottery.service.inter.ILotConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-9-9.
 */
@Service
public class LotConfigService implements ILotConfigService {
    @Autowired
    private LotConfigMapper mapper;

    public List<LotConfig> findAll(){
        return  mapper.findAll();
    }
}
