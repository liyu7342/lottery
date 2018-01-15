package com.fr.lottery.service.impl;

import com.fr.lottery.condition.StatisCondition;
import com.fr.lottery.dao.ReportMapper;
import com.fr.lottery.entity.*;
import com.fr.lottery.dto.MemberReportDto;
import com.fr.lottery.service.inter.IHandicapService;
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
    @Autowired
    private IHandicapService handicapService;
    @Override
    public List<MemberReportDto> getMemberReportDto(String id, String account, String name, String level, Integer type, String draw_date, String draw_date2) {
        //reportMapper.getMemberReportDto()
        return null;
    }

    @Override
    public List<DailiReport> getDailiReport(String handicapId, String userId) {
        Handicap handicap = handicapService.getHandicap(handicapId);
        StatisCondition condition = new StatisCondition();
        condition.setP_handicapId(handicapId);
        condition.setP_userId(userId);
        if(handicap.getStatus()<2) {
            return reportMapper.getDailiReport(condition);
        }
        else {
            return reportMapper.getDailiReportHasSettlement(condition);
        }

    }

    @Override
    public List<ZongdaiReport> getZongDaiReport(String handicapId, String userId) {
        Handicap handicap = handicapService.getHandicap(handicapId);
        StatisCondition condition = new StatisCondition();
        condition.setP_handicapId(handicapId);
        condition.setP_userId(userId);
        if(handicap.getStatus()<2) {
            return reportMapper.getZongDaiReport(condition);
        }
        else {
            return reportMapper.getZongDaiReportHasSettlement(condition);
        }
    }
    @Override
    public List<GudongReport> getGudongReport(String handicapId, String userId) {
        Handicap handicap = handicapService.getHandicap(handicapId);
        StatisCondition condition = new StatisCondition();
        condition.setP_handicapId(handicapId);
        condition.setP_userId(userId);
        if(handicap.getStatus()<2) {
            return reportMapper.getGudongReport(condition);
        }
        else {
            return reportMapper.getGudongReportHasSettlement(condition);
        }
    }

    @Override
    public List<DagudongReport> getDagudongReport(String handicapId, String userId) {
        Handicap handicap = handicapService.getHandicap(handicapId);
        StatisCondition condition = new StatisCondition();
        condition.setP_handicapId(handicapId);
        condition.setP_userId(userId);
        if(handicap.getStatus()<2) {
            return reportMapper.getDagudongReport(condition);
        }
        else {
            return reportMapper.getDagudongReportHasSettlement(condition);
        }
    }

    @Override
    public List<GudongReport> getAdminReport(String handicapId){
        StatisCondition  condition = new StatisCondition();
        condition.setP_handicapId(handicapId);
        return reportMapper.getAdminReport(condition);
    }

}
