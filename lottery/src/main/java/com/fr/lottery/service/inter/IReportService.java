package com.fr.lottery.service.inter;

import com.fr.lottery.entity.DailiReport;
import com.fr.lottery.entity.GudongReport;
import com.fr.lottery.dto.MemberReportDto;
import com.fr.lottery.entity.ZongdaiReport;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-12-27.
 */
public interface IReportService {
    List<MemberReportDto> getMemberReportDto(String id,String account,String name,String level,Integer type,String draw_date,String draw_date2);

    List<DailiReport> getDailiReport(String handicapId, String userId);

    List<ZongdaiReport> getZongDaiReport(String handicapId, String userId);

    List<GudongReport> getGudongReport(String handicapId, String userId);

    List<GudongReport> getDagudongReport(String handicapId, String userId);
    List<GudongReport> getAdminReport(String handicapId);

}
