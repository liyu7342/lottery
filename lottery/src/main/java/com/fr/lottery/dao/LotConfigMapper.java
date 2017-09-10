package com.fr.lottery.dao;

import com.fr.lottery.entity.LotConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-9-9.
 */
@Repository
public interface LotConfigMapper {

    List<LotConfig> findAll();
}
