package com.fr.lottery.dao;

import com.fr.lottery.condition.StatisCondition;
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

    List<DailiReport> getDailiReportHasSettlement(StatisCondition condition);


    List<ZongdaiReport>  getZongDaiReport(StatisCondition condition);

    List<ZongdaiReport>  getZongDaiReportHasSettlement(StatisCondition condition);


    List<GudongReport> getGudongReport(StatisCondition condition);

    List<GudongReport> getGudongReportHasSettlement(StatisCondition condition);

    List<DagudongReport> getDagudongReport(StatisCondition condition);

    List<DagudongReport> getDagudongReportHasSettlement(StatisCondition condition);

    List<GudongReport> getAdminReport(StatisCondition condition);

}