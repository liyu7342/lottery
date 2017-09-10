package com.fr.lottery.service.inter;

import com.fr.lottery.entity.LotConfig;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-9-9.
 */
public interface ILotConfigService {
    List<LotConfig> findAll();
}
