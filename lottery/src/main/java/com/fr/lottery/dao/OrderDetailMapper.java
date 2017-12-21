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

    int updateWinAmountByPrimaryKey(@Param("winAmount") Float winAmount, @Param("id") String id);

    /**
     * 开奖，结算
     * @param handicapId
     */
    void settlement(@Param("handicapId") String handicapId);

    List<OrderDetailDto> getOrderDetailsByDaili(@Param("handicapId") String handicapId,@Param("userId") String userId, @Param("xpath") String xpath,
                                         @Param("gameType") String gameType,@Param("numbers") String numbers, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
    long getDetailsTotalByDaili (@Param("handicapId") String handicapId, @Param("xpath") String xpath,  @Param("gameType") String gameType,@Param("numbers") String numbers);

    /**
     * 收付统计 总计
     * @param handicapId
     * @param userId
     * @param xpath
     * @param gameType
     * @param numbers
     * @return
     */
    OrderDetailDto getStatsByDaili(@Param("handicapId") String handicapId,@Param("userId") String userId, @Param("xpath") String xpath,
                                         @Param("gameType") String gameType,@Param("numbers") String numbers);

    List<OrderDetailDto> getBuhuoes(@Param("handicapId") String handicapId,@Param("gameType") String game_id, @Param("userId") String userId);
}