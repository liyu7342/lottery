package com.fr.lottery.dao;

import com.fr.lottery.entity.ShengXiao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-9-11.
 */
@Repository
public interface ShengxiaoMapper {
    List<ShengXiao> findByYear(@Param("currentYear") Integer currentYear);
}
