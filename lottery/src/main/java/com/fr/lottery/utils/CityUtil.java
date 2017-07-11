package com.fr.lottery.utils;

import com.fr.lottery.service.inter.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/4/1.
 */
@Component
public class CityUtil {
    @Autowired
    private ICityService cityService;

    private static CityUtil cityUtil;

    @PostConstruct
    public void init() {
        cityUtil = this;
        cityUtil.cityService = this.cityService;
    }

    public static String getCityPinYin(String cityName){
       return cityUtil.cityService.getCityPinYin(cityName);
    }

    public static String getCityCode(String cityName){
        return cityUtil.cityService.getCityCode(cityName);
    }

}
