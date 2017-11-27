package com.fr.lottery.dao;

import com.fr.lottery.entity.BucangConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
@Repository
public interface BucangConfigMapper {
    List<BucangConfig> getDatas(@Param("userId")String userId);

    BucangConfig getBuCangConfig(@Param("userId") String userId,@Param("category") String category,@Param("gameType") String gameType);

    Integer insert(BucangConfig config);

    Integer update(BucangConfig config);
}
