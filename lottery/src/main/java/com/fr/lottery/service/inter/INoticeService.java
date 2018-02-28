package com.fr.lottery.service.inter;

import com.fr.lottery.dto.Page;
import com.fr.lottery.entity.Notice;

import java.util.List;

/**
 * Created by Liyu7342 on 2018-1-28.
 */
public interface INoticeService {
    Integer save(Notice notice);
    Notice getLatestDailyNotice();
    Page<Notice> getDailyNotices(Integer pageId, Integer pageSize);
    Page<Notice> getSystemNotices(Integer pageId, Integer pageSize);
}
