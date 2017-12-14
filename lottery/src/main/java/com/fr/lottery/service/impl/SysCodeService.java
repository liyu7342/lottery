package com.fr.lottery.service.impl;

import com.fr.lottery.dao.SysCodeMapper;
import com.fr.lottery.entity.SysCode;
import com.fr.lottery.enums.CodeTypeEnum;
import com.fr.lottery.service.inter.ISysCodeService;
import com.fr.lottery.utils.DateTimeUtils;
import com.fr.lottery.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Liyu7342 on 2017-10-22.
 */
@Service
public class SysCodeService implements ISysCodeService {

    @Autowired
    SysCodeMapper sysCodeMapper;

    @Override
    public synchronized String getAutoCode(String handicapId) {
        Long seq = sysCodeMapper.getNextSeq(CodeTypeEnum.單號.getValue(),handicapId);
        if(seq==null)
            seq=1L;
        else
            seq+=1L;

        Date currentDate = new Date();
        String dateStr =DateTimeUtils.Date2String(currentDate,"yyMMdd");
        String seqStr = String.format("%06d", seq);
        String autoCode ="Z"+dateStr +seqStr;
        SysCode sysCode =new SysCode();
        sysCode.setId(StringUtil.getUUID());
        sysCode.setCodeKey(handicapId);
        sysCode.setCodeType(CodeTypeEnum.單號.getValue());
        sysCode.setCreateDate(new Date());
        sysCode.setSeq(seq);
        sysCodeMapper.insert(sysCode);

        return autoCode;
    }

    @Override
    public synchronized String getBuCangAutoCode(String handicapId) {
        Long seq = sysCodeMapper.getNextSeq(CodeTypeEnum.補倉單號.getValue(),handicapId);
        if(seq==null)
            seq=1L;
        else
            seq+=1L;

        Date currentDate = new Date();
        String dateStr =DateTimeUtils.Date2String(currentDate,"yyMMdd");
        String seqStr = String.format("%06d", seq);
        String autoCode ="B"+dateStr +seqStr;
        SysCode sysCode =new SysCode();
        sysCode.setId(StringUtil.getUUID());
        sysCode.setCodeType(CodeTypeEnum.補倉單號.getValue());
        sysCode.setCodeKey(handicapId);
        sysCode.setSeq(seq);
        sysCode.setCreateDate(new Date());
        sysCodeMapper.insert(sysCode);

        return autoCode;
    }

    @Override
    public synchronized String getQiShuAutoCode(){
        Calendar cal=Calendar.getInstance();
        cal.setTimeZone(TimeZone.getDefault());
        Lunar lunar=new Lunar(cal);
        String year =Integer.toString(lunar.getYear());
        Long seq = sysCodeMapper.getNextSeq(CodeTypeEnum.期數.getValue(),year);
        if(seq==null)
            seq=1L;
        else
            seq+=1L;
        String seqStr = String.format("%03d", seq);
        String autoCode =seqStr;
        SysCode sysCode =new SysCode();
        sysCode.setId(StringUtil.getUUID());
        sysCode.setCodeType(CodeTypeEnum.期數.getValue());
        sysCode.setCodeKey(year);
        sysCode.setSeq(seq);
        sysCode.setCreateDate(new Date());
        sysCodeMapper.insert(sysCode);

        return autoCode;
    }
}
