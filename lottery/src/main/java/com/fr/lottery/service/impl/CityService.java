package com.fr.lottery.service.impl;

import com.fr.lottery.dao.CityMapper;
import com.fr.lottery.entity.City;
import com.fr.lottery.service.inter.ICityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Liyu7342 on 2017-6-17.
 */
@Service
public class CityService implements ICityService {

    @Resource
    private CityMapper cityMapper;

    @Override
    public void insert(City entity) {
        //cityMapper.insert(entity);
    }

    @Override
    public List<City> getCities() {
        return null;
      // return cityMapper.getCities();
    }

    @Override
    public String getCityPinYin(String cityName) {
        return null;
    }

    @Override
    public String getCityCode(String cityName) {
        return null;
    }
}
