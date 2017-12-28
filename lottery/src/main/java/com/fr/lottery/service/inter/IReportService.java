package com.fr.lottery.service.inter;

import com.fr.lottery.dto.MemberReportDto;

import java.util.List;

/**
 * Created by Liyu7342 on 2017-12-27.
 */
public interface IReportService {
    List<MemberReportDto> getMemberReportDto(String id,String account,String name,String level,Integer type,String draw_date,String draw_date2);
}
