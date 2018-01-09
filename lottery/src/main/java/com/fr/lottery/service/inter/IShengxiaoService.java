package com.fr.lottery.service.inter;

import com.fr.lottery.dao.ShengxiaoMapper;
import com.fr.lottery.entity.ShengXiao;

import java.util.List;
import java.util.Map;

/**
 * Created by Liyu7342 on 2017-9-11.
 */
public interface IShengxiaoService {
    List<ShengXiao> findByYear(int year);

    List<ShengXiao> findByYear();

    Map<String,String> findMapByYear();

    Map<String, ShengXiao> findMapByYear1();

    List<ShengXiao> findByDate(String date);
}
