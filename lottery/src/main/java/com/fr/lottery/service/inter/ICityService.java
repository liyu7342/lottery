package com.fr.lottery.service.inter;


import com.fr.lottery.entity.City;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */

public interface ICityService {

    void insert(City entity);

    List<City> getCities();

    String getCityPinYin(String cityName);

    String getCityCode(String cityName);
}