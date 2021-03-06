package com.fr.lottery.dao;

import com.fr.lottery.dto.OrderDetailDto;
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

    List<OrderDetail> getOrderDetailsByOrderId(@Param("orderId") String orderId);
    int updateWinAmountByPrimaryKey(@Param("winAmount") Float winAmount, @Param("id") String id);

    /**
     * 开奖，结算
     * @param handicapId
     */
    void settlement(@Param("handicapId") String handicapId);

    List<OrderDetailDto> getOrderDetailsByDaili(@Param("handicapId") String handicapId,@Param("userId") String userId, @Param("usertype") Integer usertype,
                                         @Param("gameType") String gameType,@Param("numbers") String numbers, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
    long getDetailsTotalByDaili (@Param("handicapId") String handicapId, @Param("userId") String userId,@Param("usertype") Integer usertype,
                                 @Param("gameType") String gameType,@Param("numbers") String numbers);

    /**
     * 收付统计 总计
     * @param handicapId
     * @param userId
     * @param usertype
     * @param gameType
     * @param numbers
     * @return
     */
    OrderDetailDto getStatsByDaili(@Param("handicapId") String handicapId,@Param("userId") String userId, @Param("usertype") Integer usertype,
                                         @Param("gameType") String gameType,@Param("numbers") String numbers);

    /**
     * 收付統計單項統計
     * @param handicapId
     * @param game_id
     * @param userId
     * @return
     */
    List<OrderDetailDto> getBuhuoes(@Param("handicapId") String handicapId,@Param("gameType") String game_id, @Param("userId") String userId);


    //List<OrderDetail> getOrderDetailsByOrderNo(@Param("orderNo") String orderNo);
}