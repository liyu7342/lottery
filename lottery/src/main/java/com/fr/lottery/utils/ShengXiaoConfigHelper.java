package com.fr.lottery.utils;

import com.fr.lottery.entity.ShengXiao;
import com.fr.lottery.service.inter.IShengxiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/4.
 */
@Component
public class ShengXiaoConfigHelper {
    private static ShengXiaoConfigHelper shengxiaoConfigHelper;

    @Autowired
    private IShengxiaoService shengxiaoService;

    @PostConstruct
    public void init(){
        shengxiaoConfigHelper=this;
        shengxiaoConfigHelper.shengxiaoService = this.shengxiaoService;
    }

    public static Map<String ,ShengXiao> findShengxiaos(){
        return shengxiaoConfigHelper.shengxiaoService.findMapByYear1();
    }
}
