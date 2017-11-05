package com.fr.lottery.dao;

import com.fr.lottery.entity.OrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailMapper {

    int deleteByPrimaryKey(String id);

    int insert(OrderDetail record);

    List<OrderDetail> getOrderDetails(@Param("handicapId") String handicapId, @Param("userId") String userId,
                                 @Param("gameType") String gameType, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    int updateWinAmountByPrimaryKey(@Param("winAmount") Float winAmount, @Param("id") String id);
}