package com.fr.lottery.service.impl;

import com.fr.lottery.condition.StatisCondition;
import com.fr.lottery.dao.ReportMapper;
import com.fr.lottery.dto.ReportMonthDto;
import com.fr.lottery.entity.*;
import com.fr.lottery.dto.MemberReportDto;
import com.fr.lottery.service.inter.IHandicapService;
import com.fr.lottery.service.inter.IReportService;
import org.apache.commons.lang3.StringUtils;
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
    public List<DailiReport> getDailiReport(String riqi, String riqi2, String userId) {
        if(riqi.equals(riqi2)){
            Handicap handicap = handicapService.getHandicapByRiqi(riqi);
            StatisCondition condition = new StatisCondition();
            condition.setP_handicapId(handicap.getId());
            condition.setP_userId(userId);
            if(handicap.getStatus()<2) {
                return reportMapper.getDailiReport(condition);
            }
        }
        return reportMapper.getDailiReportHasSettlement(riqi,riqi2,userId);
    }

    @Override
    public List<ZongdaiReport> getZongDaiReport(String riqi,String riqi2, String userId) {
        if(riqi.equals(riqi2)){
            Handicap handicap = handicapService.getHandicapByRiqi(riqi);
            StatisCondition condition = new StatisCondition();
            condition.setP_handicapId(handicap.getId());
            condition.setP_userId(userId);
            if(handicap.getStatus()<2) {
                return reportMapper.getZongDaiReport(condition);
            }
        }
        return reportMapper.getZongDaiReportHasSettlement(riqi,riqi2,userId);
    }
    @Override
    public List<GudongReport> getGudongReport(String riqi,String riqi2, String userId) {
        if(riqi.equals(riqi2)){
            Handicap handicap = handicapService.getHandicapByRiqi(riqi);
            StatisCondition condition = new StatisCondition();
            condition.setP_handicapId(handicap.getId());
            condition.setP_userId(userId);
            if(handicap.getStatus()<2) {
                return reportMapper.getGudongReport(condition);
            }
        }
        return reportMapper.getGudongReportHasSettlement(riqi,riqi2,userId);
    }

    @Override
    public List<DagudongReport> getDagudongReport(String riqi,String riqi2, String userId) {

        if(riqi.equals(riqi2)){
            Handicap handicap = handicapService.getHandicapByRiqi(riqi);
            StatisCondition condition = new StatisCondition();
            condition.setP_handicapId(handicap.getId());
            condition.setP_userId(userId);
            if(handicap.getStatus()<2) {
                return reportMapper.getDagudongReport(condition);
            }
        }
        return reportMapper.getDagudongReportHasSettlement(riqi,riqi2,userId);
    }

    @Override
    public List<GudongReport> getAdminReport(String handicapId){
        StatisCondition  condition = new StatisCondition();
        condition.setP_handicapId(handicapId);
        return reportMapper.getAdminReport(condition);
    }

    @Override
    public List<ReportMonthDto> getDailiReportMonth(String riqi, String riqi2, String userId) {
       return reportMapper.getDailiReportMonth(riqi,riqi2,userId);
    }

    @Override
    public List<ReportMonthDto> getZongdaiReportMonth(String riqi, String riqi2, String userId) {
        return reportMapper.getZongdaiReportMonth(riqi,riqi2,userId);
    }

    @Override
    public List<ReportMonthDto> getGudongReportMonth(String riqi, String riqi2, String userId) {
        return reportMapper.getGudongReportMonth(riqi,riqi2,userId);
    }

    @Override
    public List<ReportMonthDto> getDagudongReportMonth(String riqi, String riqi2, String userId) {
        return reportMapper.getDagudongReportMonth(riqi,riqi2,userId);
    }

    @Override
    public List<ReportMonthDto> getAdminReportMonth(String riqi, String riqi2, String userId) {
        return reportMapper.getDailiReportMonth(riqi,riqi2,userId);
    }

    @Override
    public List<GameReport> getGameReport(String riqi, String riqi2, String categoryid, String gameid, String userId) {
        if(StringUtils.isBlank(categoryid))
            return reportMapper.getGameReport(riqi,riqi2,userId);
        else if(StringUtils.isBlank(gameid))
            return reportMapper.getGameReportByCategoryId(riqi,riqi2,userId,categoryid);
        else
            return reportMapper.getGameReportByGameId(riqi,riqi2,userId,categoryid,gameid);
    }
}
