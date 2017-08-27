package com.fr.lottery.dao;

import com.fr.lottery.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersMapper {


    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    Orders selectByPrimaryKey(String id);



    int updateByPrimaryKey(Orders record);
}