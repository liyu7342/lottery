package com.fr.lottery.service.impl;

import com.fr.lottery.dao.SysCodeMapper;
import com.fr.lottery.entity.SysCode;
import com.fr.lottery.service.inter.ISysCodeService;
import com.fr.lottery.utils.DateTimeUtils;
import com.fr.lottery.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Liyu7342 on 2017-10-22.
 */
@Service
public class SysCodeService implements ISysCodeService {

    @Autowired
    SysCodeMapper sysCodeMapper;

    @Override
    public synchronized String getAutoCode(String handicapId) {
        Long seq = sysCodeMapper.getNextSeq(handicapId);
        if(seq==null)
            seq=1L;
        else
            seq+=1L;

        Date currentDate = new Date();
        String dateStr =DateTimeUtils.Date2String(currentDate,"yyMMdd");
        String seqStr = String.format("%0" + 6 + "d", seq);
        String autoCode ="Z"+dateStr +seqStr;
        SysCode sysCode =new SysCode();
        sysCode.setId(StringUtil.getUUID());
        sysCode.setHandicapid(handicapId);
        sysCode.setSeq(seq);
        sysCodeMapper.insert(sysCode);

        return autoCode;
    }
}
