package com.fr.lottery.dao;

import com.fr.lottery.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {


    int deleteByPrimaryKey(String id);

    int insert(Order record);


    Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}