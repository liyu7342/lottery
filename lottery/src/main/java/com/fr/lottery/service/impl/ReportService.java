package com.fr.lottery.service.impl;

import com.fr.lottery.dao.ReportMapper;
import com.fr.lottery.dto.MemberReportDto;
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
}
