package com.fr.lottery.dao;

import com.fr.lottery.dto.MemberReportDto;
import com.fr.lottery.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    //long countByExample(OrderDetailExample example);


    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    List<Orders> selectByExample(@Param("orderId") String orderId);

    List<Orders> getOrderDetails(@Param("handicapId") String handicapId, @Param("userid") String userId,
                                 @Param("gameType") String gameType, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize );

    List<MemberReportDto> getOrderHistory(@Param("handicapId") String handicapId, @Param("userid") String userId);
    List<MemberReportDto> getOrderHistoryByRiqi( @Param("userid") String userId,@Param("riqi") String riqi, @Param("riqi2") String riqi2);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKey(Orders record);

    int updateWinAmountByPrimaryKey(@Param("winAmount") Float winAmount,@Param("id") String id);

    long countByUserId(@Param("handicapId") String handicapId,@Param("userid")  String userId, @Param("gameType") String gameType);

    Orders getTotal(@Param("handicapId") String handicapId, @Param("userid")  String userId, @Param("gameType") String gameType);

    int settlement(@Param("handicapId") String handicapId);

    Orders getOrdersByOrderNo(@Param("orderNo") String orderNo);

    /**
     * 獲取用戶的補貨明細總數
     * @param handicapId
     * @param game_id
     * @param userId
     * @return
     */
    Long countBuhuoesByUserId(@Param("handicapId") String handicapId,@Param("gameType") String game_id
            , @Param("userId") String userId);

    /**
     * 獲取用戶的補貨明細
     * @param handicapId
     * @param game_id
     * @param userId
     * @param pageId
     * @param pageSize
     * @return
     */
    List<Orders> getBuhuoesByUserId(@Param("handicapId") String handicapId,@Param("gameType") String game_id
            , @Param("userId") String userId,@Param("pageIndex") Integer pageId,@Param("pageSize") Integer pageSize);

    List<Orders> getOrdersByDaili(@Param("riqi") String riqi,@Param("riqi2") String riqi2,@Param("userId") String userId,
                               @Param("gameType") String gameType,@Param("number") String number,@Param("pageIndex") Integer pageIndex
                                ,@Param("pageSize") Integer pageSize);
    Integer countOrdersByDaili(@Param("riqi") String riqi,@Param("riqi2") String riqi2,@Param("userId") String userId,
                             @Param("gameType") String gameType,@Param("number") String number);
    Orders getTotalByDaili(@Param("riqi") String riqi,@Param("riqi2") String riqi2,@Param("userId") String userId,
                               @Param("gameType") String gameType,@Param("number") String number);
    List<Orders> getOrdersByZongDai(@Param("riqi") String riqi,@Param("riqi2") String riqi2,@Param("userId") String userId,
                                  @Param("gameType") String gameType,@Param("number") String number,@Param("pageIndex") Integer pageIndex
            ,@Param("pageSize") Integer pageSize);
    Integer countOrdersByZongdai(@Param("riqi") String riqi,@Param("riqi2") String riqi2,@Param("userId") String userId,
                               @Param("gameType") String gameType,@Param("number") String number);
    Orders getTotalByZongdai(@Param("riqi") String riqi,@Param("riqi2") String riqi2,@Param("userId") String userId,
                           @Param("gameType") String gameType,@Param("number") String number);
    List<Orders> getOrdersByGudong(@Param("riqi") String riqi,@Param("riqi2") String riqi2,@Param("userId") String userId,
                                  @Param("gameType") String gameType,@Param("number") String number,@Param("pageIndex") Integer pageIndex
            ,@Param("pageSize") Integer pageSize);
    Integer countOrdersByGudong(@Param("riqi") String riqi,@Param("riqi2") String riqi2,@Param("userId") String userId,
                               @Param("gameType") String gameType,@Param("number") String number);
    Orders getTotalByGudong(@Param("riqi") String riqi,@Param("riqi2") String riqi2,@Param("userId") String userId,
                           @Param("gameType") String gameType,@Param("number") String number);
    List<Orders> getOrdersByDagudong(@Param("riqi") String riqi,@Param("riqi2") String riqi2,@Param("userId") String userId,
                                  @Param("gameType") String gameType,@Param("number") String number,@Param("pageIndex") Integer pageIndex
            ,@Param("pageSize") Integer pageSize);
    Integer countOrdersByDagudong(@Param("riqi") String riqi,@Param("riqi2") String riqi2,@Param("userId") String userId,
                               @Param("gameType") String gameType,@Param("number") String number);
    Orders getTotalByDagudong(@Param("riqi") String riqi,@Param("riqi2") String riqi2,@Param("userId") String userId,
                           @Param("gameType") String gameType,@Param("number") String number);
}