package com.fr.lottery.service.inter;

import com.fr.lottery.dto.ReportMonthDto;
import com.fr.lottery.entity.*;
import com.fr.lottery.dto.MemberReportDto;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-12-27.
 */
public interface IReportService {
    List<MemberReportDto> getMemberReportDto(String id,String account,String name,String level,Integer type,String draw_date,String draw_date2);

    List<DailiReport> getDailiReport(String riqi,String riqi2, String userId);

    List<ZongdaiReport> getZongDaiReport(String riqi,String riqi2, String userId);

    List<GudongReport> getGudongReport(String riqi,String riqi2, String userId);

    List<DagudongReport> getDagudongReport(String riqi,String riqi2, String userId);
    List<GudongReport> getAdminReport(String handicapId);


    List<ReportMonthDto> getDailiReportMonth(String riqi ,String riqi2,String userId);
    List<ReportMonthDto> getZongdaiReportMonth(String riqi ,String riqi2,String userId);
    List<ReportMonthDto> getGudongReportMonth(String riqi ,String riqi2,String userId);
    List<ReportMonthDto> getDagudongReportMonth(String riqi ,String riqi2,String userId);
    List<ReportMonthDto> getAdminReportMonth(String riqi ,String riqi2,String userId);

    List<GameReport> getGameReport(String riqi, String riqi2, String categoryid, String gameid, String userId);
}
