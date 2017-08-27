package com.fr.lottery.dao;

import com.fr.lottery.entity.OrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailMapper {
    //long countByExample(OrderDetailExample example);


    int deleteByPrimaryKey(String id);

    int insert(OrderDetail record);

    List<OrderDetail> selectByExample(@Param("orderId") String orderId);

    OrderDetail selectByPrimaryKey(String id);

    int updateByPrimaryKey(OrderDetail record);
}