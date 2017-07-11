package com.fr.lottery.dao;

import com.fr.lottery.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */
@Repository
public interface CityMapper {
    int insert(City entity);

    List<City> getCities();


}
