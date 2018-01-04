package com.fr.lottery.service.impl;

import com.fr.lottery.condition.StatisCondition;
import com.fr.lottery.dao.ReportMapper;
import com.fr.lottery.dto.DailiReportDto;
import com.fr.lottery.dto.MemberReportDto;
import com.fr.lottery.dto.ZongdaiReportDto;
import com.fr.lottery.service.inter.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-12-27.
 */
@Service
public class ReportService implements IReportService {
    @Autowired
    private ReportMapper reportMapper;
    @Override
    public List<MemberReportDto> getMemberReportDto(String id, String account, String name, String level, Integer type, String draw_date, String draw_date2) {
        //reportMapper.getMemberReportDto()
        return null;
    }

    @Override
    public List<DailiReportDto> getDailiReport(String handicapId, String userId) {
        StatisCondition  condition = new StatisCondition();
        condition.setP_handicapId(handicapId);
        condition.setP_userId(userId);
        return reportMapper.getDailiReport(condition);
    }

    @Override
    public List<ZongdaiReportDto> getZongDaiReport(String handicapId, String userId) {
        StatisCondition  condition = new StatisCondition();
        condition.setP_handicapId(handicapId);
        condition.setP_userId(userId);
        return reportMapper.getZongDaiReport(condition);
    }
}
