package com.fr.lottery.dao;

import com.fr.lottery.condition.StatisCondition;
import com.fr.lottery.dto.ReportMonthDto;
import com.fr.lottery.entity.*;
import com.fr.lottery.dto.MemberReportDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportMapper {
    //long countByExample(OrderDetailExample example);


    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    List<Orders> selectByExample(@Param("orderId") String orderId);

    List<Orders> getOrderDetails(@Param("handicapId") String handicapId, @Param("userid") String userId,
                                 @Param("gameType") String gameType, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    List<MemberReportDto> getOrderHistory(@Param("handicapId") String handicapId, @Param("userid") String userId);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKey(Orders record);

    int updateWinAmountByPrimaryKey(@Param("winAmount") Float winAmount, @Param("id") String id);

    long countByUserId(@Param("handicapId") String handicapId, @Param("userid") String userId, @Param("gameType") String gameType);

    Orders getTotal(@Param("handicapId") String handicapId, @Param("userid") String userId, @Param("gameType") String gameType);

    int settlement(@Param("handicapId") String handicapId);

    List<DailiReport> getDailiReport(StatisCondition condition);

    List<DailiReport> getDailiReportHasSettlement(@Param("riqi") String riqi, @Param("riqi2")String riqi2,@Param("p_userId") String userId);


    List<ZongdaiReport>  getZongDaiReport(StatisCondition condition);

    List<ZongdaiReport>  getZongDaiReportHasSettlement(@Param("riqi") String riqi, @Param("riqi2")String riqi2,@Param("p_userId") String userId);


    List<GudongReport> getGudongReport(StatisCondition condition);

    List<GudongReport> getGudongReportHasSettlement(@Param("riqi") String riqi, @Param("riqi2")String riqi2,@Param("p_userId") String userId);

    List<DagudongReport> getDagudongReport(StatisCondition condition);

    List<DagudongReport> getDagudongReportHasSettlement(@Param("riqi") String riqi, @Param("riqi2")String riqi2,@Param("p_userId") String userId);

    List<GudongReport> getAdminReport(StatisCondition condition);


    List<ReportMonthDto> getDailiReportMonth(@Param("riqi") String riqi, @Param("riqi2")String riqi2,@Param("userId") String userId);
    List<ReportMonthDto> getZongdaiReportMonth(@Param("riqi") String riqi, @Param("riqi2")String riqi2,@Param("userId") String userId);
    List<ReportMonthDto> getGudongReportMonth(@Param("riqi") String riqi, @Param("riqi2")String riqi2,@Param("userId") String userId);
    List<ReportMonthDto> getDagudongReportMonth(@Param("riqi") String riqi, @Param("riqi2")String riqi2,@Param("userId") String userId);

    List<GameReport> getGameReport(@Param("riqi") String riqi, @Param("riqi2")String riqi2,@Param("userId") String userId);
    List<GameReport> getGameReportByCategoryId(@Param("riqi") String riqi, @Param("riqi2")String riqi2,@Param("userId") String userId,@Param("categoryid") String categoryid);
    List<GameReport> getGameReportByGameId(@Param("riqi") String riqi, @Param("riqi2")String riqi2,@Param("userId") String userId
                ,@Param("categoryid") String categoryid,@Param("gametype") String gameid);

}