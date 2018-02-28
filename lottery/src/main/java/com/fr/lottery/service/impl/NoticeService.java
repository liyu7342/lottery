package com.fr.lottery.service.impl;

import com.fr.lottery.dao.NoticeMapper;
import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.Notice;
import com.fr.lottery.enums.NoticeEnum;
import com.fr.lottery.init.Global;
import com.fr.lottery.service.inter.INoticeService;
import com.fr.lottery.utils.StringUtil;
import com.fr.lottery.utils.UserHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Liyu7342 on 2018-1-28.
 */
@Service
public class NoticeService  implements INoticeService{
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public Integer save(Notice notice) {
        if(StringUtils.isBlank(notice.getId())){
            notice.setId(StringUtil.getUUID());
            notice.setCreateDate(new Date());
            notice.setCreateUserId(UserHelper.getCurrentUser().getId());
            return noticeMapper.insert(notice);
        }
        else{
            return noticeMapper.update(notice);
        }
    }

    @Override
    public Notice getLatestDailyNotice() {
        List<Notice> notices = noticeMapper.getNotices(NoticeEnum.daily.ordinal(),0,1);
        if(notices.size()>0){
            return notices.get(0);
        }
        return null;
    }

    @Override
    public Page<Notice> getDailyNotices(Integer pageId, Integer pageSize){
        List<Notice> notices = noticeMapper.getNotices(NoticeEnum.daily.ordinal(),(pageId-1)* pageSize,pageSize);
        long total=0L;
        total = noticeMapper.count(NoticeEnum.daily.ordinal());
        Page<Notice> page = new Page<Notice>((pageId-1) * pageSize,pageSize,total);
        page.setList(notices);
        return page;
    }

    @Override
    public Page<Notice> getSystemNotices(Integer pageId, Integer pageSize){
        List<Notice> notices = noticeMapper.getNotices(NoticeEnum.system.ordinal(),(pageId-1) * pageSize,pageSize);
        long total=0L;
        total = noticeMapper.count(NoticeEnum.system.ordinal());
        Page<Notice> page = new Page<Notice>(pageId,pageSize,total);
        page.setList(notices);
        return page;
    }


}
