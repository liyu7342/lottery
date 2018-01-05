package com.fr.lottery.dao;

import com.fr.lottery.condition.StatisCondition;
import com.fr.lottery.dto.DailiReportDto;
import com.fr.lottery.dto.GudongReportDto;
import com.fr.lottery.dto.MemberReportDto;
import com.fr.lottery.dto.ZongdaiReportDto;
import com.fr.lottery.entity.Orders;
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

    List<DailiReportDto> getDailiReport(StatisCondition condition);

    List<ZongdaiReportDto>  getZongDaiReport(StatisCondition condition);

    List<GudongReportDto> getGudongReport(StatisCondition condition);

    List<GudongReportDto> getDagudongReport(StatisCondition condition);
}